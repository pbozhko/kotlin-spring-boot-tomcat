package com.example.controllers

import com.example.task.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.async.DeferredResult
import java.util.concurrent.ForkJoinPool

@RestController
class DefferedResultController {

    @Autowired
    lateinit var tastService: TaskService

    @GetMapping("/deffered")
    fun request(): DeferredResult<ResponseEntity<Unit>> {
        val deferredResult = DeferredResult<ResponseEntity<Unit>>()

        ForkJoinPool.commonPool().submit {
            tastService.execute()
            deferredResult.setResult(ResponseEntity.ok().build())
        }

        return deferredResult
    }
}