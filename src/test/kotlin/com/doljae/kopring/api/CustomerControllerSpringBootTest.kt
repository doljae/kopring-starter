package com.doljae.kopring.api

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
internal class CustomerControllerSpringBootTest {

    @Test
    fun init() {
    }

    companion object {
        @Container
        @ServiceConnection
        var db: MySQLContainer<*> = MySQLContainer("mysql:8.0.33")
    }
}
