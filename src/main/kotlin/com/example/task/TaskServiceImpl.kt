package com.example.task

import org.springframework.stereotype.Service

@Service
class TaskServiceImpl: TaskService {

    override fun execute() {
        Thread.sleep(5000)
    }
}