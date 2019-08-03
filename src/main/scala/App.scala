import com.twitter.finagle.http.Request
import com.twitter.finatra.http.{Controller, HttpServer}
import com.twitter.finatra.http.routing.HttpRouter

object AppMain extends AppServer

class AppServer extends HttpServer {
  override protected def configureHttp(router: HttpRouter): Unit = {
    router.add[HelloController]
  }
}

class HelloController extends Controller {
  get("/hello") { request: Request => "Hello!" }
}