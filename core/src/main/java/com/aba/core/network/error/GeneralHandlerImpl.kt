package com.aba.core.network.error

import com.aba.core.DataConstants
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import okio.IOException
import java.net.HttpURLConnection
import javax.inject.Inject

class GeneralHandlerImpl @Inject constructor() : ErrorContainer {
    override fun getError(throwable: Throwable): ErrorEntity {
        return when (throwable) {
            is IOException -> ErrorEntity.Network
            is HttpException -> {
                when (throwable.code()) {
                    DataConstants.Network.HttpStatusCode.UNSATISFIABLE_REQUEST -> ErrorEntity.Network

                    HttpURLConnection.HTTP_NOT_FOUND -> ErrorEntity.NotFound

                    HttpURLConnection.HTTP_FORBIDDEN -> ErrorEntity.AccessDenied

                    HttpURLConnection.HTTP_UNAVAILABLE -> ErrorEntity.ServiceUnavailable

                    else -> ErrorEntity.Unknown()
                }
            }
            else -> ErrorEntity.Unknown(throwable.message.toString())
        }
    }
}