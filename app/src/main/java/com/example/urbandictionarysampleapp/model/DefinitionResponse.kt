package com.example.urbandictionarysampleapp.model

import com.google.gson.annotations.SerializedName

data class DefinitionResponse(
        @SerializedName("list")
        var list: List<Definition>
)
