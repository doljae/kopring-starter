package com.infcon.kopring.configuration

import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
open class WithTestContainersJunit5 {

    companion object {
        @JvmStatic
        @Container
        @ServiceConnection
        var db: MySQLContainer<*> = MySQLContainer("mysql:8.0.33")
    }
}
