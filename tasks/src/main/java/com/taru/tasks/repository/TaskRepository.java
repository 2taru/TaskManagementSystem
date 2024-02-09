package com.taru.tasks.repository;

import com.taru.tasks.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByAssignedTo(String username);
}
