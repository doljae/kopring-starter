package com.doljae.kopring.api

import com.doljae.kopring.util.InfconProperties
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val properties: InfconProperties,
) {

    @GetMapping("/test")
    fun test(): ResponseEntity<String> {
        return ResponseEntity.ok("Hello Kopring!")
    }

    @GetMapping("/test/infcon")
    fun testInfcon(): ResponseEntity<InfconProperties> {
        return ResponseEntity.ok(properties)
    }
}
