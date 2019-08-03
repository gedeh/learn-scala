name := "learn-scala-finatra"
version := "0.1"

scalaVersion := "2.12.8"

lazy val versions = new {
  val finatra = "19.7.0"
  val logback = "1.2.3"
  val guice = "4.2.2"
}

libraryDependencies ++= Seq(
  "com.twitter" %% "finatra-http" % versions.finatra, // use library built for specific Scala version, i.e. finatra-http_2.12
  "ch.qos.logback" % "logback-classic" % versions.logback, // use library not built for specific Scala version

  "com.twitter" %% "finatra-http" % versions.finatra % "test",
  "com.twitter" %% "finatra-jackson" % versions.finatra % "test",
  "com.twitter" %% "inject-server" % versions.finatra % "test",
  "com.twitter" %% "inject-app" % versions.finatra % "test",
  "com.twitter" %% "inject-core" % versions.finatra % "test",
  "com.twitter" %% "inject-modules" % versions.finatra % "test",
  "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test",

  "com.twitter" %% "finatra-http" % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "finatra-jackson" % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "inject-server" % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "inject-app" % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "inject-core" % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "inject-modules" % versions.finatra % "test" classifier "tests",

  "org.mockito" % "mockito-core" % "1.9.5" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "org.specs2" %% "specs2-mock" % "2.4.17" % "test"
)