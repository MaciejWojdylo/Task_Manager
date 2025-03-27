package com.example.taskmanager.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ApiController {
    @Operation(summary = "Pobierz listę zadań", description = "Zwraca wszystkie zadania")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Lista zadań została zwrócona"),
            ApiResponse(responseCode = "500", description = "Błąd serwera")
        ]
    )
    @GetMapping("/tasks")
    fun getTasks(): List<String> {
        return listOf("Task 1", "Task 2", "Task 3")
    }
}