package com.doljae.kopring.api.request

import com.doljae.kopring.domain.Gender
import java.time.LocalDate

data class CustomerRegistrationRequest(
    val username: String,
    val gender: Gender,
    val birthDate: LocalDate,
)