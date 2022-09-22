package by.murzo.inetshop.config;

import by.murzo.inetshop.model.Order;
import by.murzo.inetshop.model.OrderItem;
import by.murzo.inetshop.model.Product;
import by.murzo.inetshop.model.User;
import by.murzo.inetshop.repository.OrderItemRepository;
import by.murzo.inetshop.repository.OrderRepository;
import by.murzo.inetshop.repository.ProductRepository;
import by.murzo.inetshop.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class JpaConfig {

    @Bean
    public DataSource mySqlDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/inetshop");
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("123456Na");
        return dataSourceBuilder.build();
    }

    @Bean
    public ApplicationRunner dataLoader(UserRepository userRepo, ProductRepository productRepo,
                                        OrderRepository orderRepo, OrderItemRepository orderItemRepo) {

        log.info("----------------started-----------------");

        userRepo.deleteAll();
        productRepo.deleteAll();
        orderRepo.deleteAll();
        orderItemRepo.deleteAll();
        log.info("----------------deleted all info from repos-----------------");

        return args -> {

            User user0 = User.builder().name("Dmitry").surname("Murzo").build();
            User user1 = User.builder().name("Alex").surname("Korinchuk").build();

            userRepo.save(user0);
            userRepo.save(user1);
            log.info("----------------users saved-----------------");

            Product product0 = Product.builder().name("PS5").price(600).build();
            Product product1 = Product.builder().name("XBOX").price(550).build();
            Product product2 = Product.builder().name("Lego").price(100).build();
            Product product3 = Product.builder().name("Iphone").price(1000).build();
            Product product4 = Product.builder().name("Notebook").price(750).build();

            productRepo.save(product0);
            productRepo.save(product1);
            productRepo.save(product2);
            productRepo.save(product3);
            productRepo.save(product4);
            log.info("----------------products saved-----------------");

            Order order0 = new Order("active", user0);
            Order order1 = new Order("in delivery", user1);

            orderRepo.save(order0);
            orderRepo.save(order1);
            log.info("----------------orders saved-----------------");

            OrderItem orderItem0 = new OrderItem(order0, product0, 2);
            OrderItem orderItem01 = new OrderItem(order0, product1, 1);
            OrderItem orderItem10 = new OrderItem(order1, product2, 1);
            OrderItem orderItem11 = new OrderItem(order1, product3, 2);
            OrderItem orderItem12 = new OrderItem(order1, product4, 1);;

            orderItemRepo.save(orderItem0);
            orderItemRepo.save(orderItem01);
            orderItemRepo.save(orderItem10);
            orderItemRepo.save(orderItem11);
            orderItemRepo.save(orderItem12);
            log.info("----------------orderItems saved-----------------");


        };
    }


}
