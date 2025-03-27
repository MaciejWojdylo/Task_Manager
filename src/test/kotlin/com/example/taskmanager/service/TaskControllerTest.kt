package com.example.taskmanager.service

import com.example.taskmanager.model.Task
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.put

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest(@Autowired val mockMvc: MockMvc, @Autowired val taskService: TaskService) {

    @Test
    fun `should create a task`() {
        val task = Task(title = "New Task", description = "Task description")

        mockMvc.post("/tasks") {
            contentType = org.springframework.http.MediaType.APPLICATION_JSON
            content = """{"title": "New Task", "description": "Task description"}"""
        }
            .andExpect {
                status { isCreated() }
                jsonPath("$.title") { value("New Task") }
            }
    }

    @Test
    fun `should update a task`() {
        val task = taskService.createTask(Task(title = "Task to Update", description = "Update description"))

        mockMvc.put("/tasks/${task.id}") {
            contentType = org.springframework.http.MediaType.APPLICATION_JSON
            content = """{"title": "Updated Task", "description": "Updated description"}"""
        }
            .andExpect {
                status { isOk() }
                jsonPath("$.title") { value("Updated Task") }
            }
    }

    @Test
    fun `should delete a task`() {
        val task = taskService.createTask(Task(title = "Task to Delete", description = "Delete description"))

        mockMvc.delete("/tasks/${task.id}")
            .andExpect {
                status { isNoContent() }
            }
    }
}
