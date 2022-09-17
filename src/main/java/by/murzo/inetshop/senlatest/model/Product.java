package by.murzo.inetshop.senlatest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer price;
    private productStatus status = productStatus.values()[(int) (Math.random() * productStatus.values().length+1)];
    private Date createdAt = new Date();

    public enum productStatus {
        OUT_OF_STOCK, IN_STOCK, RUNNING_LOW;
    }

}
