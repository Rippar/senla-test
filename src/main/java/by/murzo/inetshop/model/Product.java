package by.murzo.inetshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder()
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "products")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private Integer price;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column
    private productStatus status = productStatus.values()[(int) (Math.random() * productStatus.values().length)];

    @Builder.Default
    @Column
    private Date createdAt = new Date();

    @OneToMany(mappedBy = "product")
    private List<OrderItems> ordersQuantity;

    public enum productStatus {
        OUT_OF_STOCK, IN_STOCK, RUNNING_LOW;
    }

}
