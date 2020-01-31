package com.example.urbandictionarysampleapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.urbandictionarysampleapp.model.Definition
import com.example.urbandictionarysampleapp.R
import kotlinx.android.synthetic.main.definition_item.view.*

class DefinitionAdapter(private var definitionList: List<Definition>) :
    RecyclerView.Adapter<DefinitionAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.definition_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) = holder.bind(definitionList[position])

    override fun getItemCount(): Int = definitionList.size

    fun update(newList : List<Definition>) {
        definitionList = newList
        notifyDataSetChanged()
    }

    class CustomViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(definition: Definition) {
            val resources = itemView.context.resources
            view.word.text = resources.getString(R.string.single_text, definition.word)
            view.definition.text = resources.getString(R.string.single_text, definition.definition)
            view.example.text = resources.getString(R.string.single_text, definition.example)
            view.author.text = resources.getString(R.string.author_date, definition.author, definition.date)
            view.thumbs_up.text = resources.getString(R.string.single_text, definition.thumbsUp.toString())
            view.thumbs_down.text = resources.getString(R.string.single_text, definition.thumbsDown.toString())
        }
    }
}