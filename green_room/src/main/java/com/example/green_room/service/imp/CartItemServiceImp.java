package com.example.green_room.service.imp;

import com.example.green_room.dto.CartItemDTO;
import com.example.green_room.entity.CartItems;
import com.example.green_room.entity.Carts;

import java.util.List;
import java.util.Set;

public interface CartItemServiceImp {

    boolean insertCartItem(int cartId, int productId, int quantity);
    List<CartItemDTO> getALl();
    CartItems getById(int id);
    CartItemDTO getByIdDTO(int id);
    CartItemDTO convertToDTO(CartItems cartItem);
    List<CartItemDTO> convertToListDTO(List<CartItems> listCartItem);



}
