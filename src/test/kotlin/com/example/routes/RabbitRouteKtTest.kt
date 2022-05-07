package com.example.routes;

import com.example.plugins.configureRouting
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test

public class RabbitRouteKtTest {

    @Test
    fun testGetRandomrabbit() {
        withTestApplication({ configureRouting() }) {
            handleRequest(HttpMethod.Get, "/randomRabbit").apply {
                TODO("Please write your test here")
            }
        }
    }
}