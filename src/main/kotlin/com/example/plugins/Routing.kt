package com.example.plugins

import com.example.models.Article
import com.example.routes.randomRabbit
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.util.*

fun Application.configureRouting() {


    routing {
        randomRabbit()
        get("/") {
            call.respondRedirect("articles")
        }
        // Static plugin. Try to access `/static/index.html`
        static() {
            resources("static")
        }
    }
}
