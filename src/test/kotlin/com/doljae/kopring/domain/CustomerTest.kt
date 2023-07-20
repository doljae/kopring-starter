package com.doljae.kopring.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class CustomerTest {

    @Test
    fun init() {
        println("Hello Kopring!")
    }

    @Test
    fun `fullName은 firstName과 lastName을 space 구분자로 합친 문자열이다`() {
        val customer = Customer(
            firstName = "Seokjae",
            lastName = "Lee",
            gender = Gender.MALE,
            birthDate = LocalDate.now(),
        )
        val expectedFullName = "${customer.firstName} ${customer.lastName}"

        assertEquals(expectedFullName, customer.fullName)
    }
}
