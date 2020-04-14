package com.aba.core.network.error

interface ErrorContainer {
    fun getError(throwable: Throwable): ErrorEntity
}