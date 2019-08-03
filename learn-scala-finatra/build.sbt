name := "learn-scala-finatra"
version := "0.1"

scalaVersion := "2.12.8"

lazy val versions = new {
  val finatra = "19.7.0"
  val logback = "1.2.3"
}

libraryDependencies ++= Seq(
  "com.twitter" %% "finatra-http" % versions.finatra, // use library built for specific Scala version, i.e. finatra-http_2.12
  "ch.qos.logback" % "logback-classic" % versions.logback // use library not built for specific Scala version
)