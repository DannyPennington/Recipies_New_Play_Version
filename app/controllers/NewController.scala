package controllers

import javax.inject._
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
}