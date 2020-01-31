package com.example.urbandictionarysampleapp.networking

import androidx.lifecycle.MutableLiveData
import com.example.urbandictionarysampleapp.model.DefinitionResponse
import com.example.urbandictionarysampleapp.utils.ERROR
import com.example.urbandictionarysampleapp.utils.ResponseStatus
import com.example.urbandictionarysampleapp.utils.SUCCESS
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DefinitionRepository {

    private var definitionAPI: DefinitionAPI = RetrofitClientInstance.createService(DefinitionAPI::class.java)


    fun getDefinitions(term: String): MutableLiveData<DefinitionResponse> {
        val definitionData = MutableLiveData<DefinitionResponse>()
        definitionAPI.getDefinitions(term).enqueue(object : Callback<DefinitionResponse> {
            override fun onResponse(
                call: Call<DefinitionResponse>,
                response: Response<DefinitionResponse>
            ) {
                if (response.isSuccessful) {
                    definitionData.value = response.body()

                } else {
                }
            }

            override fun onFailure(call: Call<DefinitionResponse>, t: Throwable) {
            }
        })
        return definitionData
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