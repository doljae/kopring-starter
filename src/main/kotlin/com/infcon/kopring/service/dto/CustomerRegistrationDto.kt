package com.infcon.kopring.service.dto

import com.infcon.kopring.domain.Customer
import com.infcon.kopring.domain.Gender
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
