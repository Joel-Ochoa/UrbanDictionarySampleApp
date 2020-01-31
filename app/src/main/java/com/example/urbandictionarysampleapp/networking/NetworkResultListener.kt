package com.example.urbandictionarysampleapp.networking


//TODO implement this interface instead of the callback
interface NetworkResultListener {

    fun onSucess(any: Any)

    fun onFailure(any: Any)
}