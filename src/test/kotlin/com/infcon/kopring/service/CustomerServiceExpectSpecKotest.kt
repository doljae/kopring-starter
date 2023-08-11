package com.infcon.kopring.service

import com.infcon.kopring.domain.Customer
import com.infcon.kopring.domain.Gender
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.data.repository.findByIdOrNull
import java.time.LocalDate

@ExtendWith(MockKExtension::class)
internal class CustomerServiceExpectSpecKotest : ExpectSpec() {

    init {
        val customerRepository = mockk<CustomerRepository>()
        val customerService = CustomerService(customerRepository)

        expect("retrieveWithKotestAssertions") {
            every { customerRepository.findByIdOrNull(any()) } returns Customer(
                firstName = "Seokjae",
                lastName = "Lee",
                gender = Gender.MALE,
                birthDate = LocalDate.now(),
            )

            val result = customerService.retrieve(id)

            result.firstName shouldBe firstName
            result.lastName shouldBe lastName
            result.gender shouldBe gender
            result.gender shouldBeIn Gender.entries
            result.gender shouldNotBe Gender.FEMALE
            result.birthDate shouldBe birthDate
        }

        expect("retrieveWithTraditionalAssertions") {
            every { customerRepository.findByIdOrNull(any()) } returns Customer(
                firstName = "Seokjae",
                lastName = "Lee",
                gender = Gender.MALE,
                birthDate = LocalDate.now(),
            )

            val result = customerService.retrieve(id)

            assertEquals(firstName, result.firstName)
            assertEquals(lastName, result.lastName)
            assertEquals(gender, result.gender)
            assertEquals(birthDate, result.birthDate)
        }
    }

    companion object {
        private const val id = 1L
        private const val firstName = "Seokjae"
        private const val lastName = "Lee"
        private val gender = Gender.MALE
        private val birthDate = LocalDate.now()
    }
}
