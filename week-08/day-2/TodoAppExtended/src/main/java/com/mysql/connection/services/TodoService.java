package com.mysql.connection.services;

import com.mysql.connection.models.Todo;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TodoService {
    Todo getById(long id);
    List<Todo> listAll();
    List<Todo> listByDone(Boolean state);
    void add(Todo todo);
    void edit(Todo todo);
    void deleteById(long id);
    List<Todo> listAllBy(String searchTerm);
    List<Todo> findAllByCreationDate(LocalDate date);
    List<Todo> findAllByDueDate(LocalDate dateSearch);
    List<Todo> findByAssigneeName(String name);
    List<Todo> findAllByAssignee_Id(Long id);
}
