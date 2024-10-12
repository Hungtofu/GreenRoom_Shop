package com.example.green_room.service.imp;


import com.example.green_room.dto.OrderDTO;
import com.example.green_room.entity.Orders;
import com.example.green_room.entity.Users;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public interface OrderServiceImp{

    boolean insertOrder(int userId, String status, BigDecimal total);
    List<OrderDTO> getall();
    Orders getById(int id);
    OrderDTO getByIdDTO(int id);
    List<OrderDTO> convertToListDTO(List<Orders> listOrder);
    OrderDTO convertToDTO(Orders orders);

}
