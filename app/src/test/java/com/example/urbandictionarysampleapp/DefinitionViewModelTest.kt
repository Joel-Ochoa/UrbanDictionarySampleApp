package com.example.urbandictionarysampleapp

import com.example.urbandictionarysampleapp.model.Definition
import com.example.urbandictionarysampleapp.viewmodel.DefinitionViewModel
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class DefinitionViewModelTest {

    val viewModel: DefinitionViewModel = DefinitionViewModel()
    var definition:Definition = mock(Definition::class.java)
    var definition2:Definition = mock(Definition::class.java)
    var definition3: Definition = mock(Definition::class.java)

    init {
        `when`(definition.thumbsUp).thenReturn(15)
        `when`(definition2.thumbsUp).thenReturn(50)
        `when`(definition3.thumbsUp).thenReturn(20)

        `when`(definition.thumbsDown).thenReturn(15)
        `when`(definition2.thumbsDown).thenReturn(5)
        `when`(definition3.thumbsDown).thenReturn(10)
    }
    @Test
    fun sortThumbsUpTest() {
        val definitionsList = listOf(definition)
        val thumbsUpList = viewModel.sortThumbsUp(definitionsList)
        Assert.assertEquals(thumbsUpList[0],50)
        Assert.assertEquals(thumbsUpList[1],20)
        Assert.assertEquals(thumbsUpList[2],15)
    }

    @Test
    fun sortThumbsDownTest() {
        val definitionsList = listOf(definition)
        val thumbsDownList = viewModel.sortThumbsDown(definitionsList)
        Assert.assertEquals(thumbsDownList[0],15)
        Assert.assertEquals(thumbsDownList[1],10)
        Assert.assertEquals(thumbsDownList[2],5)
    }

}