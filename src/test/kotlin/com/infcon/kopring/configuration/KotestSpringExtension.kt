package com.infcon.kopring.configuration

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.extensions.spring.SpringExtension
import io.kotest.extensions.spring.SpringTestExtension

class KotestSpringExtension : AbstractProjectConfig() {
    override fun extensions(): List<SpringTestExtension> = listOf(SpringExtension)
}
