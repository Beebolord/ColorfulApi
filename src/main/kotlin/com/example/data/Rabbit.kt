package com.example.data

import com.google.gson.annotations.SerializedName
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



data class Shifts (
    @SerializedName("date") val date : String,
    @SerializedName("job") val job : String,
    @SerializedName("Shift")val shift : String
        )