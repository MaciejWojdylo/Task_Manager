package com.example.taskmanager.model
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank


@Entity
@Table(name = "tasks")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @field:NotBlank(message = "Name is required")
    var title: String = "",

    var description: String = "",
    var completed: Boolean = false
)
