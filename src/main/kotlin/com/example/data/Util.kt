package com.example.ticket.Data.Shedule

import Tutorial
import com.example.data.Shift
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.serialization.Serializable
import java.io.File

class Util {
    fun getData(): List<Shift> {
        val file = File("""C:\Users\ismae\IdeaProjects\ColorfulApi\src\main\resources\static\file.json""")
        val typeToken = object : TypeToken<List<Tutorial.Shift>>() {}.type
        val authors = Gson().fromJson<List<Shift>>(file.bufferedReader(), typeToken)
        println(authors)
        return authors
    }
    fun readFileDirectlyAsText(fileName: String): String
            = File(fileName).readText(Charsets.UTF_8)
}
@Serializable
data class ShoppingListItem(val desc: String, val priority: Int) {
    val id: Int = desc.hashCode()

    companion object {
        const val path = "/shoppingList"
    }
}
@Serializable
data class Shift(
    val date: String,
    val job: String,
    val hours: String,
) {
    val id: Int = date.hashCode()
}


