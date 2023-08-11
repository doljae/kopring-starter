package com.infcon.kopring.api.request

import com.infcon.kopring.domain.Gender
import java.time.LocalDate

data class CustomerUpdateRequest(
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val birthDate: LocalDate,
)
