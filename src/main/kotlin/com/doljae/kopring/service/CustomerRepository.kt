package com.doljae.kopring.service

import com.doljae.kopring.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long>
