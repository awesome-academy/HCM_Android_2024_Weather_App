package com.example.androidTemplate.data.repository.dataSource.remote

import com.example.androidTemplate.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class QueryParameterAddInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val url = chain.request().url().newBuilder()
            .addQueryParameter("appid", BuildConfig.APP_ID)
            .build()

        val request = chain.request().newBuilder()
            // .addHeader("Authorization", "Bearer token")
            .url(url)
            .build()

        return chain.proceed(request)
    }
}
