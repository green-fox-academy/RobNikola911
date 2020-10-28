package com.mysql.connection.repositories;

import com.mysql.connection.models.Assignee;
import com.mysql.connection.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssigneeRepository extends JpaRepository<Assignee, Long> {

}
