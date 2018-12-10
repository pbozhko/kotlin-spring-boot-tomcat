package com.example.controllers

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BlockingControllerTest (@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `should receive http status OK with 5000ms delay`() {
        val startTime = System.currentTimeMillis()
        val response = restTemplate.getForEntity("/test", String.javaClass)
        val responseTime = System.currentTimeMillis() - startTime

        val expectedTimeout = 5000

        assertEquals(response.getStatusCode(), HttpStatus.OK)
        assertTrue(responseTime > expectedTimeout, "Response received less that $expectedTimeout ms")
    }
}