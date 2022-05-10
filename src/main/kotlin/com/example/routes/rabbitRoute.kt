package com.example.routes

import com.example.data.HexoCode
import com.example.data.Rabbit
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.netty.handler.codec.http.HttpMethod.POST

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
    get("/randomRabbit") {
        call.respond(HttpStatusCode.OK,
            rabbits.random()
        )
    }
    get("/") {
        call.respondText("HELLO WORLD I changed!", contentType = ContentType.Text.Plain)
    }

    get("/test") {
        call.respondText("Message received",contentType = ContentType.Text.Plain)
    }
    get("/firstBall") {
        call.respond(HttpStatusCode.OK,hexes)
    }
}

fun Route.posting() {
    post("/post") {
        val parameters = call.receiveParameters()

        val paramVal1 = parameters["param1"]
        val paramVal2 = parameters["param2"]
        call.respondText("This is a test POST request with parameter values $paramVal1 and $paramVal2")
    }
}