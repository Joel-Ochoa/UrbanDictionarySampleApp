package com.example.urbandictionarysampleapp.utils

data class ResponseStatus private constructor(val status: Status) {
    companion object {
        val LOADING = ResponseStatus(Status.RUNNING)
        val LOADED = ResponseStatus(Status.SUCCESS)
        val ERROR = ResponseStatus(Status.FAILED)
    }

    enum class Status {
        RUNNING,
        SUCCESS,
        FAILED
    }
}