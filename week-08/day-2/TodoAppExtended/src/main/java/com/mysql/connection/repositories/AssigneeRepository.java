package com.mysql.connection.repositories;

import com.mysql.connection.models.Assignee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssigneeRepository extends JpaRepository<Assignee, Long> {
}
