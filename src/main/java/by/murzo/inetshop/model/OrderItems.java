package by.murzo.inetshop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
//@Entity
//@Table(name = "order_items")
public class OrderItems {

    private Long orderId;
    private Long productId;
    private Integer quantity;
}
