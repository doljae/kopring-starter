package com.infcon.kopring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class KopringApplication

fun main(args: Array<String>) {
    runApplication<KopringApplication>(*args)
}
