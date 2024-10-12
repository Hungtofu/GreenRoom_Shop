package com.example.green_room.service.imp;

import com.example.green_room.dto.PlantDetailDTO;
import com.example.green_room.dto.PlantListDTO;
import com.example.green_room.entity.Plants;
import com.example.green_room.payload.request.PlantRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PlantServiceImp {

    boolean insertPlant(PlantRequest plantRequest, MultipartFile[] files);
    List<PlantListDTO> getList();
    PlantDetailDTO getPlantDetail(int plantId);
    List<PlantListDTO> getByCategory(int categoryId);
    List<PlantListDTO> getRare();
    List<PlantListDTO> getNewArrival();

}
