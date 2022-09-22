package by.murzo.inetshop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "order_items")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "orders_id")
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "products_id")
    private Product product;
    private Integer quantity;

    public OrderItem(Order order, Product product, Integer quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;

        this.id = new OrderItemKey();
        this.id.orderId= order.getId();
        this.id.productId = product.getId();

        order.getProductsQuantity().add(this);
        product.getOrdersQuantity().add(this);
    }
}
