package com.example.green_room.service;

import com.example.green_room.dto.OrderDTO;
import com.example.green_room.entity.Orders;
import com.example.green_room.repository.OrderRepository;
import com.example.green_room.repository.UserRepository;
import com.example.green_room.service.imp.OrderServiceImp;
import com.example.green_room.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderService implements OrderServiceImp {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserServiceImp userServiceImp;

    @Override
    public boolean insertOrder(int userId, String status, BigDecimal total) {

        try {
            Orders order = new Orders();
            order.setUser(userRepository.findById(userId));
            order.setStatus(status);
            order.setTotal(total);
            order.setCreatedDate(Timestamp.from(Instant.now()));
            orderRepository.save(order);
            return true;
        }catch (Exception e){
            System.out.println("Error insert order: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<OrderDTO> getall() {
        return convertToListDTO(orderRepository.findAll());
    }

    @Override
    public Orders getById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public OrderDTO getByIdDTO(int id) {
        return convertToDTO(orderRepository.findById(id));
    }

    @Override
    public List<OrderDTO> convertToListDTO(List<Orders> listOrder) {
        List<OrderDTO> listOrderDTO = new ArrayList<>();
        for(Orders order : listOrder){
            listOrderDTO.add(convertToDTO(order));
        }
        return listOrderDTO;
    }

    @Override
    public OrderDTO convertToDTO(Orders order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setTotal(order.getTotal());
        orderDTO.setCreatedDate(order.getCreatedDate());
        orderDTO.setUser(userServiceImp.convertToDTO(order.getUser()));
        return orderDTO;
    }
}
