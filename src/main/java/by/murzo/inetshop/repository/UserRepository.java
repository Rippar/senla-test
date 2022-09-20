package by.murzo.inetshop.repository;

import by.murzo.inetshop.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
