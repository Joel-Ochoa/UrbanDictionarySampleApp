package com.example.urbandictionarysampleapp.view

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.urbandictionarysampleapp.R
import com.example.urbandictionarysampleapp.model.Definition
import com.example.urbandictionarysampleapp.view.adapter.DefinitionAdapter
import com.example.urbandictionarysampleapp.viewmodel.DefinitionViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    private lateinit var definitionViewModel: DefinitionViewModel
    private lateinit var definitionAdapter: DefinitionAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        definitionViewModel = ViewModelProviders.of(this).get(DefinitionViewModel::class.java)
        setupRecyclerView()
        setupSearchListener()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_thumbs_up -> {
                definitionViewModel.sortThumbsUp()
                return true
            }
            R.id.action_thumbs_down -> {
                definitionViewModel.sortThumbsDown()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * It looks for IME_ACTION_UNSPECIFIED so it can take the PC Enter key as a valid input.
     * For cellphone specific use, it should use EditorInfo.IME_ACTION_SEARCH
     */
    private fun setupSearchListener() {
        search.setOnEditorActionListener { v, actionId, event ->
            val isEnterPressed = actionId == EditorInfo.IME_ACTION_UNSPECIFIED
            if (isEnterPressed) {
                loadData(search.text.toString())
                true
            } else false
        }
    }

    private fun hideSoftKeyboard() {
        val view = this.currentFocus
        view?.let {
            val keyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            keyboard.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun loadData(term: String) {
        hideSoftKeyboard()
        showLoadingBar()
        definitionViewModel.updateList(term)
    }

    private fun setupRecyclerView() {
        definitionAdapter = DefinitionAdapter()
        definition_list.adapter = definitionAdapter
        definition_list.layoutManager = LinearLayoutManager(this)
        definitionViewModel.definitionsList
            .observe(this, Observer { definitions: List<Definition> ->
                dismissLoadingBar()
                definitionAdapter.update(definitions)
            })
    }
}