package com.example.routes

import Tutorial
import com.example.data.HexoCode
import com.example.data.Rabbit
import com.example.data.Scrawly
import com.example.ticket.Data.Shedule.Util
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
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
private val scrawly = Scrawly()
private val color = "0xff3399"
private val f = File("""C:\Users\ismae\IdeaProjects\ColorfulApi\src\main\resources\static\file.json""")
fun Route.randomRabbit() {
     val tutorial = Tutorial()
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
            call.respondText("lolza")
        }
        get("/postting") {
            call.respondFile(f)
        }


    }
