package controllers

import javax.inject.Inject
import models.CD
import play.api.mvc._

class CDController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport {

  def showCDForm:Action[AnyContent] = Action { implicit request:Request[AnyContent] =>
    Ok(views.html.cd(CD.createCDForm))
  }

  def submitCD: Action[AnyContent] = Action { implicit request:Request[AnyContent] =>
    CD.createCDForm.bindFromRequest.fold({ formWithErrors =>
      BadRequest(views.html.cd(formWithErrors))
    }, { cd =>
      Ok(cd.toString())
    })
  }

}
