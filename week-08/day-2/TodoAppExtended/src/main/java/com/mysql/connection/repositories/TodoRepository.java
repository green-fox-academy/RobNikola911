package com.mysql.connection.repositories;

import com.mysql.connection.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByTitleContainsIgnoreCase(String first);
    List<Todo> findAllByCreationDate(LocalDate date);
    List<Todo> findAllByDueDate(LocalDate dateSearch);
    List<Todo> findAllByAssignee_Id(Long id);

    @Query("SELECT u FROM Todo u WHERE UPPER(u.assignee.name) LIKE CONCAT('%',UPPER(:name),'%')")
    List<Todo> findByAssigneeName(@Param("name") String name);

}
