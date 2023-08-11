package com.infcon.kopring.configuration

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonMapperBuilder
import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.api.generator.ArbitraryContainerInfo
import com.navercorp.fixturemonkey.api.generator.DefaultNullInjectGenerator
import com.navercorp.fixturemonkey.api.introspector.JavaTypeArbitraryGenerator
import com.navercorp.fixturemonkey.jackson.plugin.JacksonPlugin
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import net.jqwik.api.arbitraries.BigDecimalArbitrary
import net.jqwik.api.arbitraries.StringArbitrary
import net.jqwik.engine.properties.arbitraries.DefaultBigDecimalArbitrary
import net.jqwik.engine.properties.arbitraries.DefaultStringArbitrary
import java.math.BigDecimal

class FixtureMonkeyConfiguration {

    companion object {
        val sut: FixtureMonkey = FixtureMonkey.builder().plugin(KotlinPlugin())
            .defaultArbitraryContainerInfoGenerator { ArbitraryContainerInfo(MIN_SIZE, MAX_SIZE) }
            .defaultNullInjectGenerator { DefaultNullInjectGenerator.NOT_NULL_INJECT }
            .javaTypeArbitraryGenerator(
                object : JavaTypeArbitraryGenerator {
                    override fun strings(): StringArbitrary {
                        return DefaultStringArbitrary().alpha().ofMinLength(10).ofMaxLength(20)
                    }

                    override fun bigDecimals(): BigDecimalArbitrary {
                        return DefaultBigDecimalArbitrary().between(BigDecimal(10), BigDecimal(1000))
                    }
                },
            )
            .plugin(
                JacksonPlugin(
                    jacksonMapperBuilder()
                        .build()
                        .registerModule(JavaTimeModule()),
                ),
            )
            .build()

        private const val MIN_SIZE = 3
        private const val MAX_SIZE = 3
    }
}
