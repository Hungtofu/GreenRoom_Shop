package com.example.green_room.service;

import com.example.green_room.dto.PotTypeDTO;
import com.example.green_room.dto.ProductDTO;
import com.example.green_room.dto.ProductVariantDTO;
import com.example.green_room.dto.SizeDTO;
import com.example.green_room.entity.Plants;
import com.example.green_room.entity.PotTypes;
import com.example.green_room.entity.Products;
import com.example.green_room.entity.Sizes;
import com.example.green_room.payload.request.ProductRequest;
import com.example.green_room.repository.PlantRepository;
import com.example.green_room.repository.PotTypeRepository;
import com.example.green_room.repository.ProductRepository;
import com.example.green_room.repository.SizeRepository;
import com.example.green_room.service.imp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService implements ProductServiceImp {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SizeRepository sizeRepository;

    @Autowired
    PotTypeRepository potTypeRepository;

    @Autowired
    PlantRepository plantRepository;

    @Override
    public ProductVariantDTO getBySizePotType(int plantId, int sizeId, int potTypeId) {

        Plants plant = plantRepository.findById(plantId);
        Sizes size = sizeRepository.findById(sizeId);
        PotTypes potType = potTypeRepository.findById(potTypeId);
        Products product = productRepository.findByPlantAndSizeAndPotType(plant, size, potType);
        if(product != null){
            return new ProductVariantDTO(product.getId(), product.getPrice(), product.getStock(), true);
        } else {
            return new ProductVariantDTO(null, null, null, false);
        }

    }

    public ProductVariantDTO getBySize(int plantId, int sizeId){
        Plants plant = plantRepository.findById(plantId);
        Sizes size = sizeRepository.findById(sizeId);
        Products product = productRepository.findByPlantAndSize(plant, size);
        if(product != null){
            return new ProductVariantDTO(product.getId(), product.getPrice(), product.getStock(), true);
        } else {
            return new ProductVariantDTO(null, null, null, false);
        }

    }
}
