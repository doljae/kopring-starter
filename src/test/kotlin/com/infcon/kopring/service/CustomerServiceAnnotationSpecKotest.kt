package com.infcon.kopring.service

import com.infcon.kopring.domain.Customer
import com.infcon.kopring.domain.Gender
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.data.repository.findByIdOrNull
import java.time.LocalDate

@ExtendWith(MockKExtension::class)
internal class CustomerServiceAnnotationSpecKotest : AnnotationSpec() {
    @MockK
    lateinit var customerRepository: CustomerRepository

    @InjectMockKs
    lateinit var customerService: CustomerService

    @Test
    fun retrieveWithKotestAssertions() {
        every { customerRepository.findByIdOrNull(any()) } returns
            Customer(
                firstName = "Seokjae",
                lastName = "Lee",
                gender = Gender.MALE,
                birthDate = LocalDate.now(),
            )

        val result = customerService.retrieve(ID)

        result.firstName shouldBe FIRSTNAME
        result.lastName shouldBe LASTNAME
        result.gender shouldBe gender
        result.gender shouldBeIn Gender.entries
        result.gender shouldNotBe Gender.FEMALE
        result.birthDate shouldBe birthDate
    }

    @Test
    fun retrieveWithTraditionalAssertions() {
        every { customerRepository.findByIdOrNull(any()) } returns
            Customer(
                firstName = "Seokjae",
                lastName = "Lee",
                gender = Gender.MALE,
                birthDate = LocalDate.now(),
            )

        val result = customerService.retrieve(ID)

        assertEquals(FIRSTNAME, result.firstName)
        assertEquals(LASTNAME, result.lastName)
        assertEquals(gender, result.gender)
        assertEquals(birthDate, result.birthDate)
    }

    companion object {
        private const val ID = 1L
        private const val FIRSTNAME = "Seokjae"
        private const val LASTNAME = "Lee"
        private val gender = Gender.MALE
        private val birthDate = LocalDate.now()
    }
}
