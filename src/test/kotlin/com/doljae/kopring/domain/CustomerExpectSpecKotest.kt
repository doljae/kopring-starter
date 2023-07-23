package com.doljae.kopring.domain

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDate

internal class CustomerExpectSpecKotest : ExpectSpec() {
    init {
        beforeEach {
            println("${this::class.simpleName} start")
        }

        afterEach {
            println("${this::class.simpleName} end")
        }

        context("properties") {
            val customer = Customer(
                firstName = "Seokjae",
                lastName = "Lee",
                gender = Gender.MALE,
                birthDate = LocalDate.now(),
            )
            expect("customer's fullname is firstname and lastname with a space delimiter") {
                val expectedFullName = "${customer.firstName} ${customer.lastName}"
                customer.fullName shouldBe expectedFullName
            }
        }
    }
}
