package com.infcon.kopring.domain

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

        context("customer") {
            val customer = Customer(
                firstName = "Seokjae",
                lastName = "Lee",
                gender = Gender.MALE,
                birthDate = LocalDate.now(),
            )
            expect("fullname is the text of firstname and lastname combined with a space delimiter") {
                val expectedFullName = "${customer.firstName} ${customer.lastName}"
                customer.fullName shouldBe expectedFullName
            }
        }

        xcontext("use 'xcontext()' to disable all test cases in the context") {
            val customer = Customer(
                firstName = "Seokjae",
                lastName = "Lee",
                gender = Gender.MALE,
                birthDate = LocalDate.now(),
            )
            expect("fullname is the text of firstname and lastname combined with a space delimiter") {
                val expectedFullName = "${customer.firstName} ${customer.lastName}"
                customer.fullName shouldBe expectedFullName
            }
        }
    }
}
