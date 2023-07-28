package com.doljae.kopring.api.request

import com.doljae.kopring.domain.Gender
import java.time.LocalDate

data class CustomerUpdateRequest(
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val birthDate: LocalDate,
)
