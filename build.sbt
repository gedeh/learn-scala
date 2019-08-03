name := "finatra-http-service"

version := "0.1"

scalaVersion := "2.13.0"

lazy val versions = new {
  val finatra = "19.7.0"
  val logback = "1.2.3"
  val guice = "4.0"
}

libraryDependencies += "com.twitter" % "finatra-http_2.12" % versions.finatra
libraryDependencies += "ch.qos.logback" % "logback-classic" % versions.logback