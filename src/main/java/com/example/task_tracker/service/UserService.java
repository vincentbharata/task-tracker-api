package com.example.task_tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.task_tracker.model.User;
import com.example.task_tracker.repository.UserRepository;

@Service
public class UserService {
  private final UserRepository repo;

  public UserService(UserRepository repo) {
    this.repo = repo;
  }

  public User save(User user) {
    return repo.save(user);
  }

  public List<User> findAll() {
    return repo.findAll();
  }

  // public Map<Status, Long> getTaskSummary(User user) {
  //   return user.getTasks().stream()
  //     .collect(Collectors.groupingBy(Task::getStatus, Collectors.counting()));
  // }

  public User findById(Long id) {
    return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
  }
}
