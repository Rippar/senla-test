package by.murzo.inetshop.senlatest.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
public class OrderItems {

    private Long orderId;
    private Long productId;
    private Integer quantity;
}
