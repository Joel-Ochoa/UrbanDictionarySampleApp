package com.example.urbandictionarysampleapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.urbandictionarysampleapp.model.Definition
import com.example.urbandictionarysampleapp.viewmodel.DefinitionViewModel
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.junit.rules.TestRule
import org.junit.Rule



class DefinitionViewModelTest {

    private val viewModel: DefinitionViewModel = DefinitionViewModel()
    private var definition: Definition = mock(Definition::class.java)
    private var definition2: Definition = mock(Definition::class.java)
    private var definition3: Definition = mock(Definition::class.java)
    private val definitionList = listOf(definition, definition2, definition3)

    @Rule @JvmField
    var rule: TestRule = InstantTaskExecutorRule()
    init {
        `when`(definition.thumbsUp).thenReturn(1)
        `when`(definition2.thumbsUp).thenReturn(2)
        `when`(definition3.thumbsUp).thenReturn(3)

        `when`(definition.thumbsDown).thenReturn(3)
        `when`(definition2.thumbsDown).thenReturn(2)
        `when`(definition3.thumbsDown).thenReturn(1)
    }

    @Test
    fun isLiveDataUpdating() {
        viewModel.definitionsList.observeForever{ }
        viewModel.definitionsList.postValue(definitionList)
        Assert.assertEquals(1, definitionList[0].thumbsUp)
    }

    @Test
    fun isSortingByThumbsUp() {
        viewModel.definitionsList.observeForever{ }
        viewModel.definitionsList.postValue(definitionList)
        viewModel.sortThumbsUp()
        Assert.assertEquals(1, definitionList[0].thumbsUp)
        Assert.assertEquals(2, definitionList[1].thumbsUp)
        Assert.assertEquals(3, definitionList[2].thumbsUp)
    }

    @Test
    fun isSortingByThumbsDown() {
        viewModel.definitionsList.observeForever{ }
        viewModel.definitionsList.postValue(definitionList)
        viewModel.sortThumbsDown()
        Assert.assertEquals(1, definitionList[0].thumbsUp)
        Assert.assertEquals(2, definitionList[1].thumbsUp)
        Assert.assertEquals(3, definitionList[2].thumbsUp)
    }


}