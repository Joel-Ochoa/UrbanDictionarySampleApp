package com.example.urbandictionarysampleapp.model

import com.google.gson.annotations.SerializedName
import java.text.ParseException
import java.text.SimpleDateFormat

class Definition {

    @SerializedName("defid")
    var id: Int? = null
    @SerializedName("word")
    var word: String? = null
    @SerializedName("sound_urls")
    var sound: List<Any>? = null
    @SerializedName("definition")
    var definition: String? = null
    @SerializedName("example")
    var example: String? = null
    @SerializedName("author")
    var author: String? = null
    @SerializedName("written_on")
    var date: String? = null
    @SerializedName("thumbs_up")
    var thumbsUp: Int? = null
    @SerializedName("thumbs_down")
    var thumbsDown: Int? = null
    @SerializedName("permalink")
    var permalink: String? = null
    @SerializedName("current_vote")
    var currentVote: String? = null

    fun Definition(id: Int,
                   word: String,
                   sound: List<String>,
                   definition: String,
                   example: String,
                   author: String,
                   date: String,
                   thumbsUp: Int,
                   thumbsDown: Int,
                   permalink: String,
                   currentVote: String) {
        this.id = id
        this.word = word
        this.sound = sound
        this.definition = definition
        this.example = example
        this.author = author
        this.thumbsUp = thumbsUp
        this.thumbsDown = thumbsDown
        this.permalink = permalink
        this.currentVote = currentVote
        this.date = date
    }
}