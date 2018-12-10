package com.example.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BlockingController {

    @GetMapping("/test")
    fun request(): ResponseEntity<Unit> {
        Thread.sleep(5000)
        return ResponseEntity.ok().build()
    }
}