package com.mysql.connection.services;

import com.mysql.connection.models.Todo;
import com.mysql.connection.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
                .filter(todo -> todo.isDone() == state)
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> listAllBy(String searchTerm) {
        return todoRepository.findAllByTitleContainsIgnoreCase(searchTerm);
    }

    @Override
    public List<Todo> findAllByCreationDate(LocalDate date) {
        return todoRepository.findAllByCreationDate(date);
    }

    @Override
    public List<Todo> findAllByDueDate(LocalDate dateSearch) {
        return todoRepository.findAllByDueDate(dateSearch);
    }


    @Override
    public List<Todo> findByAssigneeName(String name) {
        return todoRepository.findByAssigneeName(name);
    }

    @Override
    public List<Todo> findAllByAssignee_Id(Long id) {
        return todoRepository.findAllByAssignee_Id(id);
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
