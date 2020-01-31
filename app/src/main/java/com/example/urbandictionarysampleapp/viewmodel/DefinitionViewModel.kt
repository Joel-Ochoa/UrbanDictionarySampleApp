package com.example.urbandictionarysampleapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.urbandictionarysampleapp.model.Definition
import com.example.urbandictionarysampleapp.model.DefinitionResponse
import com.example.urbandictionarysampleapp.networking.DefinitionRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DefinitionViewModel : ViewModel(), Callback<DefinitionResponse> {

    val definitionsList: MutableLiveData<List<Definition>> = MutableLiveData()
    private val definitionRepository: DefinitionRepository = DefinitionRepository.instance()

    fun updateList(term: String) {
        definitionRepository.getDefinitions(term, this)
    }

    fun sortThumbsUp() {
        definitionsList.value = definitionsList.value?.sortedBy { it.thumbsUp }?.reversed()
    }

    fun sortThumbsDown() {
        definitionsList.value = definitionsList.value?.sortedBy { it.thumbsDown }?.reversed()
    }

    override fun onFailure(call: Call<DefinitionResponse>, t: Throwable) {
        definitionsList.value = listOf()
    }

    override fun onResponse(
        call: Call<DefinitionResponse>,
        response: Response<DefinitionResponse>
    ) {
        definitionsList.value = response.body()?.list
    }
}
