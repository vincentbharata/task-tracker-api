package com.example.task_tracker.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task_tracker.model.User;
import com.example.task_tracker.service.UserService;

@RestController
@RequestMapping("/api/v1")
@Validated
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    // @GetMapping("/users/{id}/task-summary")
    // public ResponseEntity<Map<?, Long>> getTaskSummary(@PathVariable Long id) {
    //     User user = userService.findById(id);
    //     return ResponseEntity.ok(userService.getTaskSummary(user));
    // }
}
