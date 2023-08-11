package com.infcon.kopring.domain

import io.kotest.core.spec.style.ExpectSpec

internal class InitLambdaInitBlockKotest : ExpectSpec(
    {
        expect("test case with init lambda") {
            // test codes
        }
    },
) {
    init {
        expect("test case with init block") {
            // test codes
        }
    }
}
