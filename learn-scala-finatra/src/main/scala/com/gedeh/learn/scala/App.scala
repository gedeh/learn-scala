package com.gedeh.learn.scala

import com.gedeh.learn.scala.controllers.HelloController
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter

object AppMain extends AppServer

class AppServer extends HttpServer {
  override protected def configureHttp(router: HttpRouter): Unit = {
    router
      .filter[CommonFilters]
      .add[HelloController]
  }
}