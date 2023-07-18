package com.doljae.kopring.service

import com.doljae.kopring.api.request.CustomerRegistrationRequest
import com.doljae.kopring.domain.Customer
import com.doljae.kopring.service.dto.CustomerRegistrationDto
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
) {
    fun register(request: CustomerRegistrationRequest): CustomerRegistrationDto {
        val customer = Customer(
            username = request.username,
            gender = request.gender,
            birthDate = request.birthDate,
        )

        return CustomerRegistrationDto.from(customerRepository.save(customer))
    }
}
