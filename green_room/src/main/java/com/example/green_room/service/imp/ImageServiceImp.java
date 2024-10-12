package com.example.green_room.service.imp;

import com.example.green_room.dto.ImageDTO;
import com.example.green_room.entity.Images;
import com.example.green_room.entity.Plants;
import com.example.green_room.entity.Products;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface ImageServiceImp {

    Images insertImage(Plants plant, MultipartFile file);


}
