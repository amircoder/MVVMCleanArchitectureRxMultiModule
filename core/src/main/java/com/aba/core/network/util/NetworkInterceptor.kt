package com.aba.core.network.util

import com.aba.core.DataConstants
import com.aba.core.error.NetworkException
import okhttp3.Interceptor
import okhttp3.Response
import java.net.InetAddress
import java.util.concurrent.TimeUnit

class NetworkInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!isInternetAvailable()){
            throw NetworkException("network is not available!")
        }
        return chain.proceed(chain.withReadTimeout(DataConstants.Network.TIME_OUT, TimeUnit.SECONDS).request())
    }

    private fun isInternetAvailable(): Boolean {
        return try {
            val ipAddr = InetAddress.getByName("google.com")
            !ipAddr.equals("")
        } catch (e: Exception) {
            false
        }

    }
}