package com.example.routes

import com.example.data.Rabbit
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val BASE_URL = "https://api25806.herokuapp.com/"

private val rabbits = listOf(
    Rabbit("Carl","Brown rabbi","$BASE_URL/rabbits/rabbit1.png")
)
fun Route.randomRabbit() {
    get("/randomRabbit") {
        call.respond(HttpStatusCode.OK,
            rabbits.random()
        )
    }
    get("/") {
        call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
    }

}