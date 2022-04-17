package ru.learnup.springboot.ticketsalesapplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.learnup.springboot.ticketsalesapplication.model.User;
import ru.learnup.springboot.ticketsalesapplication.repository.interfaces.UserRepository;

@Component
public class MyUserService implements UserDetailsService {

    private UserRepository repository;

    @Autowired
    public  MyUserService (UserRepository repository){
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User dbUser = repository.findByLogin(username);
        if (dbUser == null)  throw new UsernameNotFoundException("нет такого юзера");
        return dbUser;
    }
}
