package com.example.routes

import com.example.data.HexoCode
import com.example.data.Rabbit
import com.example.data.Shift
import com.example.data.Tutorial
import com.example.ticket.Data.Shedule.getData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.netty.handler.codec.http.HttpMethod.POST
import io.netty.handler.codec.http.HttpResponse
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File
private val file = File("""C:\Users\ismae\IdeaProjects\ColorfulApi\src\main\resources\static\file.json""")

private const val BASE_URL = "https://api25806.herokuapp.com"

private val rabbits = listOf(
    Rabbit("Carl","Brown rabbi","$BASE_URL/rabbits/rabbit1.png")
)
private val hexes = listOf (
    HexoCode("0xff3399","First"),
    HexoCode("0xff33FF","Second")
)
private val color = "0xff3399"
fun Route.randomRabbit() {
    var shifts2 : List<Shift>? = null

        get("/randomRabbit") {
            call.respond(
                HttpStatusCode.OK,
                rabbits.random()
            )
        }
        get("/") {
            call.respondText("HELLO WORLD I changed!...once again", contentType = ContentType.Text.Plain)
        }

        get("/test") {
            call.respondText("Message received", contentType = ContentType.Text.Plain)
        }
        get("/firstBall") {
            call.respond(HttpStatusCode.OK, hexes)
        }
        get("/shedule") {
            call.respondText(getData(), contentType = ContentType.Text.Plain)
        }
        post("/postting") {
            call.respondText("yoooooooooo")
        }


    }
