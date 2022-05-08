package com.geektech.rickandmortyapp43.models

import java.io.Serializable

data class Characters(
    var name: String? = null,
    val live: String? = null,
    val image: Int? = null
):Serializable
