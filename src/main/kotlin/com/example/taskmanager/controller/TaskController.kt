package com.example.taskmanager.controller

import com.example.taskmanager.model.Task
import com.example.taskmanager.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService) {

    @GetMapping
    fun getAllTasks(): List<Task> {
        return taskService.getAllTasks()
    }

    @GetMapping("/{id}")
    fun getTask(@PathVariable id: Long): Task {
        return taskService.getTaskById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found")
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTask(@RequestBody task: Task): Task {
        return taskService.createTask(task)
    }

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: Long, @RequestBody task: Task): Task {
        return taskService.updateTask(id, task) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found")
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTask(@PathVariable id: Long) {
        taskService.deleteTask(id)
    }
}
