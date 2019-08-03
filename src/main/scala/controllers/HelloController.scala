package controllers

import com.google.inject.Singleton
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

@Singleton
class HelloController extends Controller {
  get("/hello") { request: Request =>
    "Hello!"
  }

  get("/name/:name") { request: Request =>
    val name = request.params("name")
    val message = String.format("Hey %s!", name)
    response.ok( message ).contentType("text/plain")
  }
}