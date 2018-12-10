package com.example.controllers

import com.example.task.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BlockingController {

    @Autowired
    lateinit var tastService: TaskService

    @GetMapping("/blocking")
    fun request(): ResponseEntity<Unit> {
        tastService.execute()
        return ResponseEntity.ok().build()
    }
}