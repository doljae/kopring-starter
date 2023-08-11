package com.infcon.kopring.service

import com.infcon.kopring.api.request.CustomerRegistrationRequest
import com.infcon.kopring.api.request.CustomerUpdateRequest
import com.infcon.kopring.domain.Customer
import com.infcon.kopring.service.dto.CustomerDto
import com.infcon.kopring.service.dto.CustomerRegistrationDto
import com.infcon.kopring.util.Logger.Companion.log
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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
            .also { log.info { "Customer Registration, id: ${customer.id}" } }
    }

    fun retrieve(id: Long): CustomerDto {
        val customer = customerRepository.findByIdOrNull(id) ?: throw RuntimeException()

        return CustomerDto.from(customer)
    }

    @Transactional
    fun update(id: Long, request: CustomerUpdateRequest): CustomerDto {
        val customer = customerRepository.findByIdOrNull(id) ?: throw RuntimeException()
        customer.update(request)

        return CustomerDto.from(customer)
    }
}
