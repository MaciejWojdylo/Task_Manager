package com.example.taskmanager.service

import com.example.taskmanager.model.Task
import com.example.taskmanager.repository.TaskRepository
import io.mockk.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TaskServiceTest {

 private lateinit var taskService: TaskService
 private val taskRepository: TaskRepository = mockk()

 @BeforeEach
 fun setUp() {
  taskService = TaskService(taskRepository)
 }

 @Test
 fun `should return all tasks`() {
  every { taskRepository.findAll() } returns listOf(
   Task(1, "Test 1", "Opis 1"),
   Task(2, "Test 2", "Opis 2")
  )

  val tasks = taskService.getAllTasks()
  assertEquals(2, tasks.size)
  assertEquals("Test 1", tasks[0].title)
 }

 @Test
 fun `should create a task`() {
  val task = Task(0, "Nowe zadanie", "Opis zadania")
  every { taskRepository.save(any()) } returns task.copy(id = 1)

  val savedTask = taskService.createTask(task)
  assertEquals(1, savedTask.id)
  assertEquals("Nowe zadanie", savedTask.title)
 }
}
