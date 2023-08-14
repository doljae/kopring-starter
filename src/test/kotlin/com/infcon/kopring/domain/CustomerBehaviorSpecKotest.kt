package com.infcon.kopring.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDate

internal class CustomerBehaviorSpecKotest : BehaviorSpec() {
    init {
        beforeEach {
            println("${this::class.simpleName} start")
        }

        afterEach {
            println("${this::class.simpleName} end")
        }

        Given("customer") {
            val customer = Customer(
                firstName = "Seokjae",
                lastName = "Lee",
                gender = Gender.MALE,
                birthDate = LocalDate.now(),
            )
            When("fullname") {
                val fullName = "${customer.firstName} ${customer.lastName}"
                Then("is the text of firstname and lastname combined with a space delimiter") {
                    customer.fullName shouldBe fullName
                }
            }
        }

        xGiven("use 'xGiven' to disable all test cases in the Given block") {
            val customer = Customer(
                firstName = "Seokjae",
                lastName = "Lee",
                gender = Gender.MALE,
                birthDate = LocalDate.now(),
            )
            When("fullname") {
                val fullName = "${customer.firstName} ${customer.lastName}"
                Then("is the text of firstname and lastname combined with a space delimiter") {
                    customer.fullName shouldBe fullName
                }
            }
        }
    }
}
