package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc._
import models.People
import scala.collection.mutable.ArrayBuffer

class PeopleController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport{
  var contactStorage = ArrayBuffer.empty[People]
  def showPeopleForm:Action[AnyContent] = Action { implicit request:Request[AnyContent] =>
    Ok(views.html.contact(People.createPeopleForm))
  }

  def submitPeople: Action[AnyContent] = Action { implicit request:Request[AnyContent] =>
    People.createPeopleForm.bindFromRequest.fold({ formWithErrors =>
      BadRequest(views.html.contact(formWithErrors))
    }, { person =>
      contactStorage += person
      Redirect("/").flashing("success" -> "We will get back to you shortly")
    })
  }

  def showMessages: Action[AnyContent] = Action {implicit request:Request[AnyContent] =>
    Ok(views.html.messages(contactStorage))
  }
}
