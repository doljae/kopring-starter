package com.doljae.kopring.api

import com.doljae.kopring.api.request.CustomerRegistrationRequest
import com.doljae.kopring.api.response.CustomerRegistrationResponse
import com.doljae.kopring.api.response.CustomerResponse
import com.doljae.kopring.service.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(
    private val customerService: CustomerService,
) {

    @PostMapping("/customers")
    fun register(@RequestBody request: CustomerRegistrationRequest): ResponseEntity<CustomerRegistrationResponse> {
        val customerRegistration = customerService.register(request)

        return ResponseEntity.ok().body(CustomerRegistrationResponse.from(customerRegistration))
    }

    @GetMapping("/customers/{id}")
    fun retrieve(@PathVariable id: Long): ResponseEntity<CustomerResponse> =
        ResponseEntity.ok().body(CustomerResponse.from(customerService.retrieve(id)))
}
