package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc._
import models.People

class PeopleController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport{

  def showPeopleForm:Action[AnyContent] = Action { implicit request:Request[AnyContent] =>
    Ok(views.html.contact(People.createPeopleForm))
  }

  def submitPeople: Action[AnyContent] = Action { implicit request:Request[AnyContent] =>
    People.createPeopleForm.bindFromRequest.fold({ formWithErrors =>
      BadRequest(views.html.contact(formWithErrors))
    }, { person =>
      Redirect("/").flashing()
    })
  }
}
