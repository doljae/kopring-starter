package com.doljae.kopring.service

import com.doljae.kopring.api.request.CustomerRegistrationRequest
import com.doljae.kopring.domain.Customer
import com.doljae.kopring.service.dto.CustomerDto
import com.doljae.kopring.service.dto.CustomerRegistrationDto
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
) {
    fun register(request: CustomerRegistrationRequest): CustomerRegistrationDto {
        val customer = Customer(
            firstName = request.firstName,
            lastName = request.lastName,
            gender = request.gender,
            birthDate = request.birthDate,
        )

        return CustomerRegistrationDto.from(customerRepository.save(customer))
    }

    fun retrieve(id: Long): CustomerDto {
        val customer = customerRepository.findByIdOrNull(id) ?: throw RuntimeException()

        return CustomerDto.from(customer)
    }
}
