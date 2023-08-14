package com.infcon.kopring.api

import com.infcon.kopring.service.TestService
import com.infcon.kopring.util.InfconProperties
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val testService: TestService,
    private val properties: InfconProperties,
) {

    @GetMapping("/test/v1")
    fun testApiV1(): ResponseEntity<String> {
        return ResponseEntity.ok(testService.greeting())
    }

    @GetMapping("/test/v2")
    fun testApiV2(): ResponseEntity<String> = with(testService.greeting()) {
        ResponseEntity.ok(this)
    }

    @GetMapping("/test/v3")
    fun testApiV3(): ResponseEntity<String> = ResponseEntity.ok(testService.greeting())

    @GetMapping("/test/infcon")
    fun testConfigurationProperties(): ResponseEntity<InfconProperties> {
        return ResponseEntity.ok(properties)
    }
}
