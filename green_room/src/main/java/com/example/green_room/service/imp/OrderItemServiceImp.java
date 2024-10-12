package com.example.green_room.service.imp;


import com.example.green_room.dto.OrderItemDTO;
import com.example.green_room.entity.OrderItems;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface OrderItemServiceImp {

    boolean insertOrderItem(int orderId, int productId, int quantity, BigDecimal price);
    List<OrderItemDTO> getAll();
    OrderItems getById(int id);
    OrderItemDTO getByIdDTO(int id);
    List<OrderItemDTO> convertToListDTO(List<OrderItems> listOrderItem);
    OrderItemDTO convertToDTO(OrderItems orderItem);

}
