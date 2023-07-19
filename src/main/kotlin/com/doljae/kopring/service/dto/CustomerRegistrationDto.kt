package com.doljae.kopring.service.dto

import com.doljae.kopring.domain.Customer
import com.doljae.kopring.domain.Gender
import java.time.LocalDate

data class CustomerRegistrationDto(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val birthDate: LocalDate,
) {
    companion object {
        fun from(entity: Customer): CustomerRegistrationDto = CustomerRegistrationDto(
            id = entity.id,
            firstName = entity.firstName,
            lastName = entity.lastName,
            gender = entity.gender,
            birthDate = entity.birthDate,
        )
    }
}
