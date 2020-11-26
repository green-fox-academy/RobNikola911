package com.spring.security;

import com.spring.security.models.User;
import com.spring.security.repositories.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SecurityApplication.class)
public class InMemoryDBTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void should_get_h2_db_records() {
        User userActual = userRepository.save(new User("TestName", "TestPassword"));

        Optional<User> expected = userRepository.findById(userActual.getId());

        Assert.assertEquals(userActual.getUsername(),expected.get().getUsername());
    }


}