package com.example.urbandictionarysampleapp.callback

import androidx.recyclerview.widget.DiffUtil
import com.example.urbandictionarysampleapp.model.Definition

class DefinitionDiffCallback : DiffUtil.ItemCallback<Definition>() {

    override fun areItemsTheSame(oldItem: Definition, newItem: Definition): Boolean {
        return oldItem.id == newItem.id
                && oldItem.word == newItem.word
                && oldItem.definition == newItem.definition
                && oldItem.example == newItem.example
                && oldItem.author == newItem.author
                && oldItem.date == newItem.date
                && oldItem.thumbsUp == newItem.thumbsUp
                && oldItem.thumbsDown == newItem.thumbsDown
                && oldItem.permalink == newItem.permalink
                && oldItem.sound == newItem.sound
                && oldItem.currentVote == newItem.currentVote
    }

    override fun areContentsTheSame(oldItem: Definition, newItem: Definition): Boolean {
        return oldItem.id == newItem.id
                && oldItem.word == newItem.word
                && oldItem.definition == newItem.definition
                && oldItem.example == newItem.example
                && oldItem.author == newItem.author
                && oldItem.date == newItem.date
                && oldItem.thumbsUp == newItem.thumbsUp
                && oldItem.thumbsDown == newItem.thumbsDown
                && oldItem.permalink == newItem.permalink
                && oldItem.sound == newItem.sound
                && oldItem.currentVote == newItem.currentVote


    }
}