package com.infcon.kopring.api

import com.infcon.kopring.configuration.FixtureMonkeyConfiguration.Companion.sut
import com.infcon.kopring.configuration.WithTestContainers
import com.infcon.kopring.service.CustomerService
import com.infcon.kopring.service.dto.CustomerDto
import com.navercorp.fixturemonkey.kotlin.giveMeOne
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.AnnotationSpec
import io.mockk.every
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
internal class CustomerControllerAnnotationSpecSpringBootTest : AnnotationSpec(), WithTestContainers {
    @MockkBean
    private lateinit var customerService: CustomerService

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun retrieve() {
        val id = 1L
        val uri = "/customers/$id"
        val customer = sut.giveMeOne<CustomerDto>()
        every { customerService.retrieve(any()) } returns customer

        mockMvc.get(uri)
            .andExpect { status { isOk() } }
            .andExpectAll {
                status { isOk() }
                MockMvcResultMatchers.jsonPath("$.firstName").value(customer.firstName)
                MockMvcResultMatchers.jsonPath("$.lastName").value(customer.lastName)
                MockMvcResultMatchers.jsonPath("$.gender").value(customer.gender)
                MockMvcResultMatchers.jsonPath("$.birthDate").value(customer.birthDate)
            }
            .andDo { print() }
    }
}
