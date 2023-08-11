package com.infcon.kopring.api.response

import com.infcon.kopring.domain.Gender
import com.infcon.kopring.service.dto.CustomerRegistrationDto
import java.time.LocalDate

data class CustomerRegistrationResponse(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val birthDate: LocalDate,
) {
    companion object {
        fun from(dto: CustomerRegistrationDto): CustomerRegistrationResponse =
            CustomerRegistrationResponse(
                id = dto.id,
                firstName = dto.firstName,
                lastName = dto.firstName,
                gender = dto.gender,
                birthDate = dto.birthDate,
            )
    }
}
