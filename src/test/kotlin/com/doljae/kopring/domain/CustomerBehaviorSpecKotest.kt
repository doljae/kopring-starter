package com.doljae.kopring.domain

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
            When("customer's fullname is firstname and lastname with a space delimiter") {
                val fullName = "${customer.firstName} ${customer.lastName}"
                Then("same") {
                    customer.fullName shouldBe fullName
                }
            }
        }
    }
}
