package com.example.green_room.service;

import com.example.green_room.dto.*;
import com.example.green_room.entity.Images;
import com.example.green_room.entity.Plants;
import com.example.green_room.entity.Products;
import com.example.green_room.payload.request.PlantRequest;
import com.example.green_room.repository.PlantRepository;
import com.example.green_room.repository.PlantTypeRepository;
import com.example.green_room.repository.ProductRepository;
import com.example.green_room.service.imp.ImageServiceImp;
import com.example.green_room.service.imp.PlantServiceImp;
import com.example.green_room.service.imp.PlantTypeServiceImp;
import com.example.green_room.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Service
public class PlantService implements PlantServiceImp {

    @Autowired
    PlantRepository plantRepository;

    @Autowired
    PlantTypeRepository plantTypeRepository;

    @Autowired
    ImageServiceImp imageServiceImp;

    @Override
    public boolean insertPlant(PlantRequest plantRequest, MultipartFile[] files) {
        try {
            Plants plant = new Plants();
            plant.setDisplayName(plantRequest.getDisplayName());
            plant.setCommonName(plantRequest.getCommonName());
            plant.setBotanicalName(plantRequest.getBotanicalName());
            plant.setDescription(plantRequest.getDescription());
            plant.setRare(plantRequest.isRare());
            plant.setPlantType(plantTypeRepository.findById(plantRequest.getPlantTypeId()));
            plant.setCreatedDate(Timestamp.from(Instant.now()));
            Plants savedPlant = plantRepository.save(plant);

            for(MultipartFile file: files){
                imageServiceImp.insertImage(savedPlant, file);
            }

            return true;
        }catch(Exception e){
            System.err.println("Error insert plant: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<PlantListDTO> getList() {

        List<Plants> plants = plantRepository.findAll();
        List<PlantListDTO> listPlantList = new ArrayList<>();
        for(Plants plant: plants){
            listPlantList.add(convertToDTO(plant));
        }

        return listPlantList;
    }

    @Override
    public PlantDetailDTO getPlantDetail(int plantId) {

        Plants plant = plantRepository.findById(plantId);
        PlantDetailDTO plantDetailDTO = new PlantDetailDTO();
        plantDetailDTO.setId(plantId);
        plantDetailDTO.setDisplayName(plant.getDisplayName());
        plantDetailDTO.setCommonName(plant.getCommonName());
        plantDetailDTO.setBotanicalName(plant.getBotanicalName());
        plantDetailDTO.setDescription(plant.getDescription());

        List<Products> products = plant.getProducts();
        Set<SizeDTO> setSize = new HashSet<>();
        Set<PotTypeDTO> setPotType = new HashSet<>();
        for(Products product: products){

            if(product.getPotType() != null){
                setPotType.add(new PotTypeDTO(product.getPotType().getId(), product.getPotType().getTypeName()));
            }
            if(product.getSize() != null){
                setSize.add(new SizeDTO(product.getSize().getId(), product.getSize().getSizeName()));
            }
        }
        plantDetailDTO.setSizeVariant(setSize);
        plantDetailDTO.setPotTypeVariant(setPotType);

        List<Images> listImage = plant.getImages();
        List<String> images = new ArrayList<>();
        for(Images image: listImage){
            images.add(image.getUrl());
        }
        plantDetailDTO.setImages(images);

        return plantDetailDTO;
    }

    public PlantListDTO convertToDTO(Plants plant){
        PlantListDTO plantList = new PlantListDTO();
        plantList.setId(plant.getId());
        plantList.setDisplayName(plant.getDisplayName());

        if(!plant.getImages().isEmpty()){
            plantList.setDisplayImage(plant.getImages().get(0).getUrl());
        } else {
            plantList.setDisplayImage("Green_room_2.png");
        }

        if(!plant.getProducts().isEmpty()){
            List<Products> listProduct = plant.getProducts();
            BigDecimal lowestPrice = listProduct.get(0).getPrice();
            for(Products products: listProduct){
                if(lowestPrice.compareTo(products.getPrice()) > 0){
                    lowestPrice = products.getPrice();
                }
            }

            plantList.setPriceFrom(lowestPrice);
        } else {
            plantList.setPriceFrom(null);
        }
        return plantList;
    }

    @Override
    public List<PlantListDTO> getByCategory(int categoryId) {

        List<Plants> plants = plantRepository.findByPlantType(plantTypeRepository.findById(categoryId));
        List<PlantListDTO> listPlantList = new ArrayList<>();
        for(Plants plant: plants){
            listPlantList.add(convertToDTO(plant));
        }

        return listPlantList;

    }

    @Override
    public List<PlantListDTO> getRare() {

        List<Plants> plants = plantRepository.findByIsRare(true);
        List<PlantListDTO> listPlantList = new ArrayList<>();
        for(Plants plant: plants){
            listPlantList.add(convertToDTO(plant));
        }

        return listPlantList;
    }

    @Override
    public List<PlantListDTO> getNewArrival() {

        Timestamp currentTime = Timestamp.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
        Timestamp oneMonthAgo = Timestamp.from(LocalDateTime.now().minusMonths(1).toInstant(ZoneOffset.UTC));

        List<Plants> plants = plantRepository.findNewArrival(oneMonthAgo, currentTime);
        List<PlantListDTO> listPlantList = new ArrayList<>();
        for(Plants plant: plants){
            listPlantList.add(convertToDTO(plant));
        }

        return listPlantList;
    }
}
