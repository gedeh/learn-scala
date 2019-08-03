package com.gedeh.learn.scala.controllers

import com.google.inject.Singleton
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.inject.Logging

@Singleton
class HelloController extends Controller with Logging {

  get("/hello") { request: Request =>
    info("/hello endpoint")
    "Hello!"
  }

  get("/name/:name") { request: Request =>
    val name = request.params("name")
    val message = String.format("Hey %s!", name)
    info(String.format("/name endpoint, name: %s", name))
    response.ok(Map("message" -> message)).contentTypeJson()
  }
}