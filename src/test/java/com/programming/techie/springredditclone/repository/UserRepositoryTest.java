package com.programming.techie.springredditclone.repository;

import com.programming.techie.springredditclone.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void getUserByUserNameTest(){
        User user = userRepository.getUserByUsername("spk");
        Assertions.assertEquals("sivakumartechupdate@gmail.com", user.getEmail());
    }

    @Test
    public void getUserEmailByUserNameTest(){
        String email = userRepository.getUserEmailByUsername("spk");
        Assertions.assertEquals("sivakumartechupdate@gmail.com", email);

    }
}