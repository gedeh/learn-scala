name := "finatra-http-service"
version := "0.1"

scalaVersion := "2.12.0"

lazy val versions = new {
  val finatra = "19.7.0"
  val logback = "1.2.3"
}

libraryDependencies ++= Seq(
  "com.twitter" %% "finatra-http" % versions.finatra,
  "ch.qos.logback" % "logback-classic" % versions.logback
)