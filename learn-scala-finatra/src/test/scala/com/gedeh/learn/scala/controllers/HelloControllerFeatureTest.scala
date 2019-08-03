import com.twitter.finagle.http.Status._
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest
import com.gedeh.learn.scala.AppServer
import com.fasterxml.jackson.module.scala.deser.`package`.overrides

class HelloControllerFeatureTest extends FeatureTest {

  override def printStats: Boolean = false
  override protected def server = new EmbeddedHttpServer(new AppServer)

  test("Server says hello") {
    server.httpGet(
      path = "/hello",
      andExpect = Ok,
      withBody = "Hello!")
  }

  test("Server says name") {
    val name = "foo"
    server.httpGet(
      path = String.format("/name/%s", name),
      andExpect = Ok,
      withBody = String.format("{\"message\":\"Hey %s!\"}", name))
  }
}