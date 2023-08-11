package com.infcon.kopring.service

import com.infcon.kopring.domain.Customer
import com.infcon.kopring.domain.Gender
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface CustomerRepository : JpaRepository<Customer, Long> {
    fun findByGender(gender: Gender): Customer?
    fun findByFirstName(firstName: String): Optional<Customer>
}
