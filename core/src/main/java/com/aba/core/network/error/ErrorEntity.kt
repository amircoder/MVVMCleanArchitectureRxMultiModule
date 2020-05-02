package com.aba.core.network.error

sealed class ErrorEntity {
    object Network : ErrorEntity(){
        override fun toString(): String {
            return this.javaClass.canonicalName
        }
    }

    object NotFound : ErrorEntity()

    object AccessDenied : ErrorEntity()

    object ServiceUnavailable : ErrorEntity()

    data class Unknown(val message: String = "") : ErrorEntity()
}