package com.example.green_room.service.imp;

import com.example.green_room.dto.SizeDTO;
import com.example.green_room.entity.Sizes;
import com.example.green_room.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public interface SizeServiceImp {

    boolean insertSize(String sizeName);
    List<SizeDTO> getAll();


}
