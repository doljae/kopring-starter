package com.infcon.kopring.api.exception

import com.infcon.kopring.util.Logger.Companion.log
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlers {

    @ExceptionHandler
    fun handleRuntimeException(exception: RuntimeException): ProblemDetail {
        log.error { "message: ${exception.message}, cause: ${exception.cause}" }

        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "Something was wrong")
    }
}
