package com.example.urbandictionarysampleapp

import com.example.urbandictionarysampleapp.model.Definition
import com.example.urbandictionarysampleapp.viewmodel.DefinitionViewModel
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class DefinitionViewModelTest {

    val viewModel: DefinitionViewModel = DefinitionViewModel()
    var definition: Definition = mock(Definition::class.java)
    var definition2: Definition = mock(Definition::class.java)
    var definition3: Definition = mock(Definition::class.java)

    init {
        `when`(definition.thumbsUp).thenReturn(1)
        `when`(definition2.thumbsUp).thenReturn(3)
        `when`(definition3.thumbsUp).thenReturn(2)

        `when`(definition.thumbsDown).thenReturn(2)
        `when`(definition2.thumbsDown).thenReturn(3)
        `when`(definition3.thumbsDown).thenReturn(1)
    }

    @Test
    fun sortThumbsUpTest() {
        val definitionsList = listOf(definition, definition2, definition3)
        val thumbsUpList = viewModel.sortThumbsUp(definitionsList)
        Assert.assertEquals(thumbsUpList[0].thumbsUp, 3)
        Assert.assertEquals(thumbsUpList[1].thumbsUp, 2)
        Assert.assertEquals(thumbsUpList[2].thumbsUp, 1)
    }

    @Test
    fun sortThumbsDownTest() {
        val definitionsList = listOf(definition, definition2, definition3)
        val thumbsDownList = viewModel.sortThumbsDown(definitionsList)
        Assert.assertEquals(thumbsDownList[0].thumbsDown, 3)
        Assert.assertEquals(thumbsDownList[1].thumbsDown, 2)
        Assert.assertEquals(thumbsDownList[2].thumbsDown, 1)
    }

}