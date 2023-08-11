package com.infcon.kopring.util

import org.springframework.boot.context.properties.ConfigurationProperties
import java.time.LocalDate

@ConfigurationProperties(value = "infcon")
data class InfconProperties(
    val location: String,
    val date: LocalDate,
    val url: String,
)
