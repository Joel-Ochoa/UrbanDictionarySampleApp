package com.example.urbandictionarysampleapp.networking

import com.example.urbandictionarysampleapp.utils.BASE_URL
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


class RetrofitClientInstance {

    companion object {

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun <S> createService(serviceClass: Class<S>): S {
            return retrofit.create(serviceClass)
        }
    }
}