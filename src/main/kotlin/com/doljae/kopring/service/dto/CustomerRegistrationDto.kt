package com.doljae.kopring.service.dto

import com.doljae.kopring.domain.Customer
import com.doljae.kopring.domain.Gender
import java.time.LocalDate

data class CustomerRegistrationDto(
    val id: Long,
    val username: String,
    val gender: Gender,
    val birthDate: LocalDate,
) {
    companion object {
        fun from(entity: Customer) = CustomerRegistrationDto(
            id = entity.id,
            username = entity.username,
            gender = entity.gender,
            birthDate = entity.birthDate,
        )
    }
}
