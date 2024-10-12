package com.example.green_room.service;

import com.example.green_room.dto.CartDTO;
import com.example.green_room.entity.Carts;
import com.example.green_room.repository.CartRepository;
import com.example.green_room.service.imp.CartServiceImp;
import com.example.green_room.service.imp.UserServiceImp;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CartService implements CartServiceImp {

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    CartRepository cartRepository;

    @Override
    public boolean insertCart(int userId) {
        try {
            Carts cart = new Carts();
            cart.setUser(userServiceImp.getById(userId));
            cart.setCreatedDate(Timestamp.from(Instant.now()));
            cartRepository.save(cart);
            return true;
        }catch(Exception e){
            System.out.println("Error insert cart: " + e.getMessage());
            return false;
        }

    }

    @Override
    public List<CartDTO> getAll() {
        return convertToListDTO(cartRepository.findAll());
    }

    @Override
    public Carts getById(int id) {
        return cartRepository.findById(id);
    }

    @Override
    public CartDTO getByIdDTO(int id) {
        return convertToDTO(cartRepository.findById(id));
    }

    @Override
    public CartDTO convertToDTO(Carts cart) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(cart.getId());
        cartDTO.setUser(userServiceImp.convertToDTO(cart.getUser()));
        cartDTO.setCreatedDate(cart.getCreatedDate());
        return cartDTO;
    }

    @Override
    public List<CartDTO> convertToListDTO(List<Carts> listCart) {
        List<CartDTO> listCartDTo = new ArrayList<>();
        for(Carts cart: listCart){
            listCartDTo.add(convertToDTO(cart));
        }
        return listCartDTo;
    }
}
