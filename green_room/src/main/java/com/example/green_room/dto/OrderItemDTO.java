package com.example.green_room.dto;

import com.example.green_room.entity.Orders;
import com.example.green_room.entity.Products;
import jakarta.persistence.*;

import java.math.BigDecimal;

public class OrderItemDTO {

    private int id;
    private OrderDTO order;
    private ProductDTO product;
    private int quantity;
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
