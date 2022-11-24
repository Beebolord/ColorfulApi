package com.example

import io.ktor.server.application.*
import com.example.plugins.*
import freemarker.cache.ClassTemplateLoader
import freemarker.core.HTMLOutputFormat
import io.ktor.server.engine.*
import io.ktor.server.freemarker.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8069, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
    }.start(wait = true)

}


@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {

    configureRouting()
    configureMonitoring()
    configureSerialization()
}

fun Application.configureTemplating() {
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
        outputFormat = HTMLOutputFormat.INSTANCE
    }
}
