package com.spring.security.repository;

import com.spring.security.models.User;
import com.spring.security.repositories.UserRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    User user1;

    @BeforeEach
    public void setUp()
    {
        user1 = new User();
        user1.setUsername("Believe");
        user1.setPassword("Cher");
    }
    @AfterEach
    public void tearDown(){
        userRepository.deleteAll();
    }

    @Test
    public void testSaveUser() throws  Exception{
        userRepository.save(user1);
        User fetchUser = userRepository.findById(user1.getId()).get();
        Assert.assertEquals(java.util.Optional.of(1L), java.util.Optional.ofNullable(fetchUser.getId()));

    }

    @Test
    public void testGetAllUsers() throws  Exception{
        User usertest = new User("James","alfred");
        User usertest2 = new User("Gary","carlos");
        userRepository.save(usertest);
        userRepository.save(usertest2);
        List<User> list = userRepository.findAll();
        Assert.assertEquals("James",list.get(0).getUsername());
    }

    @Test
    public void testUpdatePassword(){
        userRepository.save(user1);
        user1.setPassword("good");
        userRepository.save(user1);
        String password = (userRepository.findByUsername("Believe")).getPassword();
        Assert.assertEquals("good", password);
    }

    @Test
    public void testSaveUserFailure(){
        User testUser = new User("Sabyas","Sahu");
        userRepository.save(user1);
        User fetchUser = userRepository.findById(user1.getId()).get();
        Assert.assertNotSame(testUser,fetchUser);
    }


}
