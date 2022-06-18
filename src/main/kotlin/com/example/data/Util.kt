package com.example.ticket.Data.Shedule

import com.example.data.Shift
import com.example.data.Tutorial.Companion.file
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.runBlocking
import java.io.File
import kotlinx.coroutines.*
import java.io.IOException
fun getMyScheduleDaddy() : List<Shift> {
        val typeToken = object : TypeToken<List<Shift>>() {}.type
        val gson = Gson()
        val jsonString = gson.fromJson<List<Shift>>(file.readText(Charsets.UTF_8), typeToken)
        return jsonString
    }
