package com.example.ticket.Data.Shedule

import com.example.data.Shift
import com.example.data.Tutorial
import com.example.data.Tutorial.Companion.file
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.runBlocking
import java.io.File
import kotlinx.coroutines.*
import java.io.IOException
fun getData() : String{
    val file = File("""C:\Users\ismae\IdeaProjects\ColorfulApi\src\main\resources\static\file.json""")
    val typeToken = object : TypeToken<List<Tutorial.Shift>>() {}.type
    val authors = Gson().fromJson<List<Shift>>(file.readText(), typeToken)
    println(authors.toString())
    return authors.toString()

}
