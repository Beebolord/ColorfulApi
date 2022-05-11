package com.example.Client

import io.netty.handler.codec.http.HttpRequest
import io.netty.handler.codec.http.HttpResponse
import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolConfig.newBuilder
import sun.net.www.http.HttpClient
import java.net.URI
import java.net.http.HtpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main() {
    val client  = HttpClient.newBuilder().build();
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://colorofmyballs.herokuapp.com"))
        .build()
    val response = client.send(request, HttpResponse.BodyHandlers.ofString())
    println(response.body)
}