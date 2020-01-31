package com.example.urbandictionarysampleapp.networking

import com.example.urbandictionarysampleapp.model.DefinitionResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface DefinitionAPI {

    @Headers( "x-rapidapi-key: 226fd54a53msh4dbaf37024e2c1cp1b6d6ejsnf983b25c291e",
        "Host: mashape-community-urban-dictionary.p.rapidapi.com")
    @GET("/define")
    fun getDefinitions(@Query("term") term: String): Call<DefinitionResponse>
}
