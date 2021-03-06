package com.mysql.connection;

import com.mysql.connection.models.Todo;
import com.mysql.connection.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectionApplication implements CommandLineRunner {

    private final TodoRepository todoRepository;

    public ConnectionApplication(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConnectionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        todoRepository.save(new Todo("daily task", false, false));
        todoRepository.save(new Todo("make the beds", true, true));
        todoRepository.save(new Todo("do the washing up", true, false));
        todoRepository.save(new Todo("mop", true, true));
        todoRepository.save(new Todo("broom", true, false));
        todoRepository.save(new Todo("tidy up", false, false));
    }
}
