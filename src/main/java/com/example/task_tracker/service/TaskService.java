package com.example.task_tracker.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.task_tracker.model.Status;
import com.example.task_tracker.model.Task;
import com.example.task_tracker.repository.TaskRepository;
import com.example.task_tracker.repository.UserRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepo;
    private final UserRepository userRepo;

    public TaskService(TaskRepository taskRepo, UserRepository userRepo) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }

    public Task create(Task task) {
       userRepo.findById(task.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        // task.setUser(user);
        return taskRepo.save(task);
    }

    public List<Task> findAll(Long userId, Status status, LocalDate dueDate) {
        if (userId != null && status != null && dueDate != null)
            return taskRepo.findByUserIdAndStatusAndDueDate(userId, status, dueDate);
        if (userId != null && status != null)
            return taskRepo.findByUserIdAndStatus(userId, status);
        if (userId != null && dueDate != null)
            return taskRepo.findByUserIdAndDueDate(userId, dueDate);
        if (status != null && dueDate != null)
            return taskRepo.findByStatusAndDueDate(status, dueDate);
        if (userId != null)
            return taskRepo.findByUserId(userId);
        if (status != null)
            return taskRepo.findByStatus(status);
        if (dueDate != null)
            return taskRepo.findByDueDate(dueDate);
        return taskRepo.findAll();
    }

    public Task findById(Long id) {
        return taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task update(Long id, Task updated) {
        Task existing = findById(id);
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setStatus(updated.getStatus());
        existing.setDueDate(updated.getDueDate());
        return taskRepo.save(existing);
    }

    public void delete(Long id) {
        taskRepo.deleteById(id);
    }
}
