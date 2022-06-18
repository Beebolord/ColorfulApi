package com.example.ticket.Data.Shedule

import java.io.File
import java.io.IOException
fun getJsonDataFromAsset(): String? {
    val file: File = File("""C:\Users\ismae\IdeaProjects\ColorfulApi\src\main\resources\static\file.json""")
    val jsonString: String
    try {
        jsonString = file.bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}
