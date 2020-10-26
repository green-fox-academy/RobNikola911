package com.listingtodos.embeddeddb;

import com.listingtodos.embeddeddb.models.Todo;
import com.listingtodos.embeddeddb.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmbeddedDbApplication implements CommandLineRunner {

    private final TodoRepository todoRepository;

    public EmbeddedDbApplication(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmbeddedDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        todoRepository.save(new Todo("I have to learn Object Relational Mapping"));
        todoRepository.save(new Todo("I have to learn a lot"));
        todoRepository.save(new Todo("I have to learn everything"));
    }
}
