package com.mysql.connection;

import com.mysql.connection.models.Todo;
import com.mysql.connection.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectionApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConnectionApplication.class, args);
    }

}
