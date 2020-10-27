package com.mysql.connection.services;

import com.mysql.connection.models.Todo;
import com.mysql.connection.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @Override
    public Todo getById(long id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public List<Todo> listAll() {
        return todoRepository.findAll();
    }

    @Override
    public List<Todo> listByDone(Boolean state) {
        return todoRepository.findAll().stream()
                .filter(todo -> todo.getDone() == state)
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> listAllBy(String searchTerm, String searchBy) {
        return todoRepository.findAllByTitleContainsIgnoreCase(searchTerm);
    }


    @Override
    public void add(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void edit(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void deleteById(long id) {
        todoRepository.delete(getById(id));
    }
}
