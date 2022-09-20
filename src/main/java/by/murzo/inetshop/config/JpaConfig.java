package by.murzo.inetshop.config;

import by.murzo.inetshop.model.Product;
import by.murzo.inetshop.model.User;
import by.murzo.inetshop.repository.ProductRepository;
import by.murzo.inetshop.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {

    private UserRepository userRepository;
    private ProductRepository productRepository;

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
    public ApplicationRunner userLoader(UserRepository userRepository) {
        userRepository.deleteAll();
        return args -> {
            userRepository.save(User.builder().name("Dmitry").surname("Murzo").build());
            userRepository.save(User.builder().name("Alex").surname("Korinchuk").build());


        };
    }

    @Bean
    public ApplicationRunner productLoader(ProductRepository productRepository) {
        productRepository.deleteAll();
        return args -> {
            productRepository.save(Product.builder().name("Lego").price(100).build());
            productRepository.save(Product.builder().name("Iphone").price(1000).build());
            productRepository.save(Product.builder().name("Notebook").price(750).build());
            productRepository.save(Product.builder().name("Tyre").price(90).build());
            productRepository.save(Product.builder().name("TV").price(500).build());
            productRepository.save(Product.builder().name("Xbox").price(515).build());
            productRepository.save(Product.builder().name("PS5").price(600).build());

        };
    }

}
