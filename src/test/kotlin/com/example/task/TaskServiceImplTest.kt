package com.example.task

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import kotlin.test.assertEquals

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskServiceImplTest {

    @Autowired
    lateinit var taskService: TaskService

    @Test
    fun `Should delay 5000ms`() {
        val startTime = System.currentTimeMillis()
        taskService.execute()
        val duration = System.currentTimeMillis() - startTime
        assertEquals(5000, duration)
    }
}