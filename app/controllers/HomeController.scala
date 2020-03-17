package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index: Action[AnyContent] = Action { implicit request:Request[AnyContent] =>
    if (request.flash.get("success").isDefined) {
      Ok(views.html.index(request.flash.data("success")))
    }
    else {Ok(views.html.index("Check out this sweet homepage"))}
  }

}
