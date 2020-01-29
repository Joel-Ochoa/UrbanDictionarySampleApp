package com.example.urbandictionarysampleapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.urbandictionarysampleapp.model.Definition


class DefinitionViewModel : ViewModel() {

    fun sortThumbsUp(definitionsList: List<Definition>): List<Definition> = definitionsList.sortedBy { it.thumbsUp }.reversed()

    fun sortThumbsDown(definitionsList: List<Definition>): List<Definition> = definitionsList.sortedBy { it.thumbsDown }.reversed()

}