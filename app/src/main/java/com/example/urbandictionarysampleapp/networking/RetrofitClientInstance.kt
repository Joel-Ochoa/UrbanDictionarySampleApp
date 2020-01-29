package com.example.urbandictionarysampleapp.networking

import com.example.urbandictionarysampleapp.utils.BASE_URL
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



class RetrofitClientInstance {


    companion object {
        var retrofit: Retrofit? = null

        fun getRetrofitInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}