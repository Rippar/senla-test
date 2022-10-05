package by.murzo.inetshop.service;

import by.murzo.inetshop.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(Long id);
}
