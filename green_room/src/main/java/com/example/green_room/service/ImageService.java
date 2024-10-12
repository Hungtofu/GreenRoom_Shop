package com.example.green_room.service;

import com.example.green_room.dto.ImageDTO;
import com.example.green_room.entity.Images;
import com.example.green_room.entity.Plants;
import com.example.green_room.entity.Products;
import com.example.green_room.repository.ImageRepository;
import com.example.green_room.repository.ProductRepository;
import com.example.green_room.service.imp.ImageServiceImp;
import com.example.green_room.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

@Service
public class ImageService implements ImageServiceImp {

    @Autowired
    ImageRepository imageRepository;


    @Value("${fileUpload.root-path}")
    private String rootPath;

    private Path root;

    public void init() throws IOException {

        try {
            root = Paths.get(rootPath);
            if(Files.notExists(root)){
                Files.createDirectories(root);
            }
        }catch (Exception e){
            System.out.println("Error create folder root: " + e.getMessage());
        }

    }

    public String saveImage(MultipartFile file) {

        try {
            init();
            String fileName = Objects.requireNonNull(file.getOriginalFilename());
            Path targetPath = this.root.resolve(fileName);
            if(Files.exists(targetPath)){
                fileName = generateUniqueFileName(fileName);
                targetPath = this.root.resolve(fileName);
            }

            Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Save file to: " + targetPath);
            return fileName;

        } catch (Exception e){
            System.out.println("Error save file: " + e.getMessage());
            return null;
        }
    }

    public String generateUniqueFileName(String originalFileName){
        String fileName = originalFileName;
        int count = 1;

        while (Files.exists(this.root.resolve(fileName))) {
            String name = originalFileName.substring(0, originalFileName.lastIndexOf('.'));
            String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
            fileName = name + "_" + count + extension;
            count++;
        }

        return fileName;
    }


    public Resource loadImage(String fileName) {
        try {
            init();
            Path file = root.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw new RuntimeException("Could not read the file");
            }

        }catch (Exception e){
            System.out.print("Error load image: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Images insertImage(Plants plant, MultipartFile file) {
        try {
            Images image = new Images();
            image.setPlant(plant);
            image.setUrl(saveImage(file));
            image.setCreatedDate(Timestamp.from(Instant.now()));
            Images savedImage = imageRepository.save(image);
            System.out.println("success insert image to: " + savedImage.getUrl());
            return savedImage;
        }catch(Exception e) {
            System.out.println("Error insert image: " + e.getMessage());
            return null;
        }
    }





}
