package com.learn.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserDaoService{

    // JPA/Hibernate > Database
    private static final List<User> users = new ArrayList<>();
    private static int count = 0;

    static {
        users.add(new User(++count, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++count, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++count, "Jim", LocalDate.now().minusYears(20)));
    }

    // For now -> UserDaoService > Static List

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++count);
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        Optional<User> optionalUser = users.stream().filter(predicate).findFirst();
        return optionalUser.orElse(null);
    }


    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
