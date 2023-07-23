package com.doljae.kopring.domain

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class CustomerJUnitTest {

    @BeforeEach
    fun before() {
        println("${this::class.simpleName} start")
    }

    @AfterEach
    fun after() {
        println("${this::class.simpleName} end")
    }

    @Test
    fun `customer's fullname is firstname and lastname with a space delimiter`() {
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
