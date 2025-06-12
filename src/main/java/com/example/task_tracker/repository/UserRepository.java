package com.example.task_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.task_tracker.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
