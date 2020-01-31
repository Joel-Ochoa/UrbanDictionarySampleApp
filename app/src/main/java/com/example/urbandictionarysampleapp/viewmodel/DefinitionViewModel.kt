package com.example.urbandictionarysampleapp.viewmodel

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.urbandictionarysampleapp.model.Definition
import com.example.urbandictionarysampleapp.model.DefinitionResponse
import com.example.urbandictionarysampleapp.networking.DefinitionRepository


class DefinitionViewModel : ViewModel() {

    private var mutableLiveData: MutableLiveData<DefinitionResponse>? = null
    private lateinit var definitionRepository: DefinitionRepository

    fun fetchData(term: String) {
        definitionRepository = DefinitionRepository.instance()

        updateList(term)
    }

    fun updateList(term: String) {
        mutableLiveData = definitionRepository.getDefinitions(term)

        addDelay()
    }

    private fun addDelay() {
        val handler = Handler()
        handler.postDelayed({
            // Do something after 5s = 5000ms
        }, 1000)
    }

    fun getDefinitionRepository(): LiveData<DefinitionResponse> = mutableLiveData!!

    fun sortThumbsUp(definitionsList: List<Definition>): List<Definition> = definitionsList.sortedBy { it.thumbsUp }.reversed()

    fun sortThumbsDown(definitionsList: List<Definition>): List<Definition> = definitionsList.sortedBy { it.thumbsDown }.reversed()

}
