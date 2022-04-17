package ru.learnup.springboot.ticketsalesapplication.repository.interfaces;

import ru.learnup.springboot.ticketsalesapplication.model.User;

public interface UserRepository {
    User findByLogin(String login);
}
