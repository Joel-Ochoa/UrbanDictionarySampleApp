package com.example.urbandictionarysampleapp.networking

import com.example.urbandictionarysampleapp.model.DefinitionResponse
import retrofit2.Callback

class DefinitionRepository {

    private var definitionAPI: DefinitionAPI = RetrofitClientInstance.createService(DefinitionAPI::class.java)

    fun getDefinitions(term: String, callback: Callback<DefinitionResponse>) {
        definitionAPI.getDefinitions(term).enqueue(callback)
    }

    companion object {

        private var definitionRepository: DefinitionRepository? = null

        fun instance(): DefinitionRepository {
            if (definitionRepository == null) {
                definitionRepository = DefinitionRepository()
            }
            return definitionRepository!!
        }
    }
}