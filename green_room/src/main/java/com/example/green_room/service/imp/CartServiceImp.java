package com.example.green_room.service.imp;


import com.example.green_room.dto.CartDTO;
import com.example.green_room.entity.Carts;

import java.util.List;
import java.util.Set;

public interface CartServiceImp {

    boolean insertCart(int userId);
    List<CartDTO> getAll();
    Carts getById(int id);
    CartDTO getByIdDTO(int id);
    CartDTO convertToDTO(Carts cart);
    List<CartDTO> convertToListDTO(List<Carts> listCart);


}
