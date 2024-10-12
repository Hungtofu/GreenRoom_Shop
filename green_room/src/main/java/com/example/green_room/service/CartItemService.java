package com.example.green_room.service;

import com.example.green_room.dto.CartItemDTO;
import com.example.green_room.entity.CartItems;
import com.example.green_room.entity.Carts;
import com.example.green_room.repository.CartItemRepository;
import com.example.green_room.repository.OrderItemRepository;
import com.example.green_room.service.imp.CartItemServiceImp;
import com.example.green_room.service.imp.CartServiceImp;
import com.example.green_room.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CartItemService implements CartItemServiceImp {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    CartServiceImp cartServiceImp;

    @Override
    public boolean insertCartItem(int cartId, int productId, int quantity) {
        try {
            CartItems cartItem = new CartItems();
            cartItem.setCart(cartServiceImp.getById(cartId));
            //cartItem.setProduct(productServiceImp.getById(productId));
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
            return true;
        }catch(Exception e){
            System.out.println("Error insert cart item: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<CartItemDTO> getALl() {
        return convertToListDTO(cartItemRepository.findAll());
    }

    @Override
    public CartItems getById(int id) {
        return cartItemRepository.findById(id);
    }

    @Override
    public CartItemDTO getByIdDTO(int id) {
        return convertToDTO(cartItemRepository.findById(id));
    }

    @Override
    public CartItemDTO convertToDTO(CartItems cartItem) {
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setId(cartItem.getId());
        cartItemDTO.setCart(cartServiceImp.convertToDTO(cartItem.getCart()));
        cartItemDTO.setProductId(cartItem.getProduct().getId());
        cartItemDTO.setQuantity(cartItem.getQuantity());
        return cartItemDTO;
    }

    @Override
    public List<CartItemDTO> convertToListDTO(List<CartItems> listCartItem) {
        List<CartItemDTO> listCartItemDTO = new ArrayList<>();
        for(CartItems cartItem: listCartItem){
            listCartItemDTO.add(convertToDTO(cartItem));
        }
        return listCartItemDTO;
    }
}
