package com.example.routes

import Tutorial
import com.example.data.HexoCode
import com.example.data.Rabbit
import com.example.data.Scrawly
import com.example.models.Article
import com.example.ticket.Data.Shedule.Util
import com.google.gson.Gson
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import kotlinx.serialization.Serializable
import java.io.File
private val file = File("""C:\Users\ismae\IdeaProjects\ColorfulApi\src\main\resources\static\file.json""")

private const val BASE_URL = "https://api25806.herokuapp.com"


private val rabbits = listOf(
    Rabbit("Carl","Brown rabbi","$BASE_URL/rabbits/rabbit1.png")
)
private val hexes = listOf (
    HexoCode("0xffff3399","First"),
    HexoCode("0xffff33FF","Second")
)

private val util = Util()
val articles = mutableListOf(Article.newEntry(
    "The drive to develop!",
    "...it's what keeps me going."
))
private val scrawly = Scrawly()
private val color = "0xff3399"
private val f = File("""C:\Users\ismae\IdeaProjects\ColorfulApi\src\main\resources\static\file.json""")

private var list = mutableListOf(Shift("hours","poste","sometjing"))
fun Route.randomRabbit() {

    get("/randomRabbit") {
            call.respond(
                HttpStatusCode.OK,
                rabbits.random()
            )
        }
        get("/") {
            call.respondText("HELLO WORLD I changed!...once again lolz", contentType = ContentType.Text.Plain)
        }

        get("/test") {

            call.respondText(Util().readFileDirectlyAsText("static/coolFile.json"), contentType = ContentType.Text.Plain)
        }
        get("/firstBall") {
            call.respond(HttpStatusCode.OK, hexes)
        }
        get("/schedule") {
            call.respondText("lolza fuck off")
        }
        post("/post") {
            list += call.receive<Shift>()
            file.writeText("")
            file.appendText(Gson().toJson(list))
            call.respond(HttpStatusCode.OK, list)
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