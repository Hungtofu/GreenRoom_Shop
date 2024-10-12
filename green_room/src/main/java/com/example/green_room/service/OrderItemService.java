package com.example.green_room.service;

import com.example.green_room.dto.OrderItemDTO;
import com.example.green_room.entity.OrderItems;
import com.example.green_room.entity.Orders;
import com.example.green_room.entity.Products;
import com.example.green_room.repository.OrderItemRepository;
import com.example.green_room.repository.OrderRepository;
import com.example.green_room.repository.ProductRepository;
import com.example.green_room.service.imp.OrderItemServiceImp;
import com.example.green_room.service.imp.OrderServiceImp;
import com.example.green_room.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderItemService implements OrderItemServiceImp {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderServiceImp orderServiceImp;


    @Override
    public boolean insertOrderItem(int orderId, int productId, int quantity, BigDecimal price) {

        try {
            OrderItems orderItems = new OrderItems();
            orderItems.setOrder(orderRepository.findById(orderId));
            orderItems.setProduct(productRepository.findById(productId));
            orderItems.setPrice(price);
            orderItems.setQuantity(quantity);
            orderItemRepository.save(orderItems);
            return true;
        }catch(Exception e){
            System.out.print("Error insert order item: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<OrderItemDTO> getAll() {
        return convertToListDTO(orderItemRepository.findAll());
    }

    @Override
    public OrderItems getById(int id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public OrderItemDTO getByIdDTO(int id) {
        return convertToDTO(orderItemRepository.findById(id));
    }

    @Override
    public List<OrderItemDTO> convertToListDTO(List<OrderItems> listOrderItem) {
        List<OrderItemDTO> listOrderItemDTO = new ArrayList<>();
        for(OrderItems orderItem : listOrderItem){
            listOrderItemDTO.add(convertToDTO(orderItem));
        }
        return listOrderItemDTO;
    }

    @Override
    public OrderItemDTO convertToDTO(OrderItems orderItem) {

        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setId(orderItem.getId());
        orderItemDTO.setOrder(orderServiceImp.convertToDTO(orderItem.getOrder()));
        orderItemDTO.setPrice(orderItem.getPrice());
        //orderItemDTO.setProduct(productServiceImp.convertToDTO(orderItem.getProduct()));
        orderItemDTO.setQuantity(orderItem.getQuantity());
        return orderItemDTO;
    }
}
