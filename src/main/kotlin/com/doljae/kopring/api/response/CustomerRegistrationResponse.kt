package com.doljae.kopring.api.response

import com.doljae.kopring.domain.Gender
import com.doljae.kopring.service.dto.CustomerRegistrationDto
import java.time.LocalDate

data class CustomerRegistrationResponse(
    val id: Long,
    val username: String,
    val gender: Gender,
    val birthDate: LocalDate,
) {
    companion object {
        fun from(dto: CustomerRegistrationDto): CustomerRegistrationResponse = CustomerRegistrationResponse(
            id = dto.id,
            username = dto.username,
            gender = dto.gender,
            birthDate = dto.birthDate,
        )
    }
}
