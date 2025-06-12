package com.example.task_tracker.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.task_tracker.model.Status;
import com.example.task_tracker.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
    List<Task> findByStatus(Status status);
    List<Task> findByDueDate(LocalDate dueDate);
    List<Task> findByUserIdAndStatus(Long userId, Status status);
    List<Task> findByUserIdAndDueDate(Long userId, LocalDate dueDate);
    List<Task> findByStatusAndDueDate(Status status, LocalDate dueDate);
    List<Task> findByUserIdAndStatusAndDueDate(Long userId, Status status, LocalDate dueDate);
}
