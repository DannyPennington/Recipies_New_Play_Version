package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.index("Hello World!")).as(HTML).withCookies(
      Cookie("colour","blue")
    )
  }
  def index2 = Action {
    Ok(views.html.index("Index2 page here")).as("text/html")
  }

  def help = Action {
    Redirect("https://www.google.com")
  }

  def cookiePage = Action { implicit request: Request[AnyContent] =>
    if (request.cookies.get("colour").isDefined) {
      Ok(request.cookies.get("colour"))
    }
    else {
      Ok(views.html.index("No cookies found here..."))
    }
  }

  def todo = TODO
}
