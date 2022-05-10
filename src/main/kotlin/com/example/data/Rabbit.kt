package com.example.data

import kotlinx.serialization.Serializable

@Serializable
data class Rabbit (
    val name : String,
    val description : String,
    val imageUrl : String
)

@Serializable
data class HexoCode (
    val hexadecimal : String,
    val ball : String
        )