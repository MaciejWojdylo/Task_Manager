package com.example.taskmanager.service

import com.example.taskmanager.model.Task
import com.example.taskmanager.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val taskRepository: TaskRepository) {

    fun getAllTasks(): List<Task> {
        return taskRepository.findAll()
    }

    fun getTaskById(id: Long): Task? {
        return taskRepository.findById(id).orElse(null)
    }

    fun createTask(task: Task): Task {
        return taskRepository.save(task)
    }

    fun updateTask(id: Long, task: Task): Task? {
        return if (taskRepository.existsById(id)) {
            task.copy(id = id).let { taskRepository.save(it) }
        } else {
            null
        }
    }

    fun deleteTask(id: Long) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id)
        } else {
            throw IllegalArgumentException("Task not found")
        }
    }
}
