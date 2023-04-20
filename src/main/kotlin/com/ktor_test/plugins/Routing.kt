package com.ktor_test.plugins

import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import kotlinx.serialization.Serializable

fun Application.configureRouting() {
    routing {

        get("/users"){
            call.respondText("All uses")

            println("url: ${call.request.uri}")

            call.request.headers.names().forEach {
                  println("$it : ${call.request.headers[it]}")
            }

        }

        post("/login") {

            val userInfo = call.receive<UserInfo>()
            println(userInfo)
            val userResponse = UserResponse("Successful", "233")
            call.respond(userResponse)
        }

    }
}


@Serializable
data class UserInfo(val email: String, val password: String)

@Serializable
data class UserResponse(val message: String, val code: String)