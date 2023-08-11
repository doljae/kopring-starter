package com.infcon.kopring.configuration

import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MySQLContainer

interface WithTestContainers {

    companion object {

        @JvmStatic
        @DynamicPropertySource
        fun initTestContainers(registry: DynamicPropertyRegistry) {
            activeTestContainers.parallelStream().forEach { it.start() }
            injectProperties(registry)
        }

        private fun injectProperties(registry: DynamicPropertyRegistry) {
            injectMySQLProperties(registry)
        }

        private fun injectMySQLProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url") { mysql.jdbcUrl }
            registry.add("spring.datasource.username") { mysql.username }
            registry.add("spring.datasource.password") { mysql.password }
        }

        private val mysql: MySQLContainer<Nothing> by lazy {
            MySQLContainer<Nothing>("mysql:8.0.33").apply {
                withDatabaseName("kopring")
                withUsername("user")
                withPassword("user")
                withCommand(
                    "--explicit-defaults-for-timestamp=ON",
                    "--character-set-server=utf8mb4",
                    "--collation-server=utf8mb4_unicode_ci",
                )
                withExposedPorts(3306)
            }
        }

        private val activeTestContainers = listOf(mysql)
    }
}
