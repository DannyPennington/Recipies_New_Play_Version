package controllers

import javax.inject._
import play.api.mvc._


class TwirlController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  val people = List(new Person("Dan",20), new Person("Greg", 30))
  def display: Action[AnyContent] = Action{ implicit request: Request[AnyContent] =>
    Ok(views.html.display("Danny")(23))
  }

  def function: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.func(people))
  }

}
