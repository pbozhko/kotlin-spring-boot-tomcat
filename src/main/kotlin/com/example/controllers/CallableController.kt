package com.example.controllers

import com.example.task.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.Callable

@RestController
class CallableController {

    @Autowired
    lateinit var tastService: TaskService

    @GetMapping("/callable")
    fun request(): Callable<ResponseEntity<Unit>> {
        return Callable<ResponseEntity<Unit>> {
            tastService.execute()
            ResponseEntity.ok().build()
        }
    }
}