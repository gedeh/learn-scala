package com.gedeh.learn.scala.controllers

import com.google.inject.Singleton
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.finatra.request.RouteParam
import com.twitter.inject.Logging

case class NameRequest(
  @RouteParam name: String
)

case class NameResponse(
  message: String
)

@Singleton
class HelloController extends Controller with Logging {
  get("/hello") { request: Request =>
    debug("/hello endpoint")
    "Hello!"
  }

  get("/name/:name") { request: NameRequest =>
    val message = String.format("Hey %s!", request.name)
    debug(String.format("/name endpoint, name: %s", request.name))
    response.ok(NameResponse(message)).contentTypeJson()
  }
}