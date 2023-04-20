package com.ktor_test.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.homeRoutingModules() {
    routing {
        get("/hello/world"){
            call.respondText("Hello Modules")
        }
    }
}