package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index: Action[AnyContent] = Action {
    Ok(views.html.index("Hello World!")).as(HTML).withCookies(
      Cookie("colour","Blue")
    )
  }
  def index2: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index("Index2 page here")).as("text/html").withSession(request.session + ("pages" -> "index2"))
  }

  def index3: Action[AnyContent] = Action { implicit request:Request[AnyContent] =>
    Ok("Adding to session").withSession(request.session + ("pages" -> "index3"))
  }
  def help: Action[AnyContent] = Action {
    Redirect("https://www.google.com")
  }

  def cookiePage: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    if (request.cookies.get("colour").isDefined) {
      Ok(views.html.index(request.cookies.get("colour").get.value))
    }
    else {
      Ok(views.html.index("No cookies found here..."))
    }
  }

  def session: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    if (request.session.get("pages").isDefined) {
      Ok(views.html.index(request.session.data("pages")))
    }
    else { Ok("No session found...")}
  }

  def todo: Action[AnyContent] = TODO
}
