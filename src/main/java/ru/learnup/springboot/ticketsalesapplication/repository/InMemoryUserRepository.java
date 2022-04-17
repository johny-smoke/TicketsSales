package ru.learnup.springboot.ticketsalesapplication.repository;

import org.springframework.stereotype.Repository;
import ru.learnup.springboot.ticketsalesapplication.model.User;
import ru.learnup.springboot.ticketsalesapplication.repository.interfaces.UserRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private Map<String, User> db = new HashMap<>();

    @PostConstruct
    public void init() {
        db.put("user", new User("user", "user123", "ROLE_USER"));
        db.put("admin", new User("admin", "admin123", "ROLE_ADMIN"));
    }

    @Override
    public User findByLogin(String login){
        return db.get(login);
    }
}
