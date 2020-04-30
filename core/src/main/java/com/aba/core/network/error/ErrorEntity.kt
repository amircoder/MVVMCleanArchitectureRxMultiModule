package com.aba.core.network.error

sealed class ErrorEntity {
    object Network : ErrorEntity()

    object NotFound : ErrorEntity()

    object AccessDenied : ErrorEntity()

    object ServiceUnavailable : ErrorEntity()

    data class Unknown(val message: String = "") : ErrorEntity()
}