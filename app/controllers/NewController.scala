package controllers

import javax.inject._
import play.api.libs.json.JsValue
import play.api.mvc._

@Singleton
class NewController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def infinite: Action[AnyContent] = Action {
    Redirect(routes.NewController.infinite())
  }

  def charset: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    implicit val myCustomCharset: Codec = Codec.javaSupported("iso-8859-1")
    Ok(views.html.index("Here's some test text"))
  }

  def read: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    if (request.flash.get("success").isDefined) {
      Ok(views.html.index(request.flash.data("success")))
    }
    else {Ok("Looks like you weren't redirected here...")}
  }

  def write: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Redirect("/read").flashing("success" -> "Successfully redirected")
  }

  def parser: Action[JsValue] = Action(parse.json) { request: Request[JsValue] =>
    if (request.isInstanceOf[JsValue]) {
      Ok((request.body \ "name" \ "age").as[String])
    }
    else {BadRequest("Name and age must be provided as json")}
  }

}