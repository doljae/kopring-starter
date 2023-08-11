package com.infcon.kopring.util

import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging

class Logger {
    companion object {
        inline val <reified T> T.log: KLogger
            get() = KotlinLogging.logger(T::class.java.name)
    }
}
