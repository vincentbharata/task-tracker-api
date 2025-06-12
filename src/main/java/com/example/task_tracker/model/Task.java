package com.example.task_tracker.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("user_id")
    private Long userId;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "due_date")
    @JsonProperty("due_date")
    private LocalDate dueDate;

    // @ManyToOne
    // @JoinColumn(name = "user_id")
    // @JsonBackReference
    // private User user;
}
