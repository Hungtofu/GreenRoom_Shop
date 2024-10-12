package com.example.green_room.service.imp;

import com.example.green_room.dto.ProductDTO;
import com.example.green_room.dto.ProductVariantDTO;
import com.example.green_room.entity.*;
import com.example.green_room.payload.request.ProductRequest;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public interface ProductServiceImp {

    ProductVariantDTO getBySizePotType(int plantId, int sizeId, int potTypeId);
    ProductVariantDTO getBySize(int plantId, int sizeId);
}
