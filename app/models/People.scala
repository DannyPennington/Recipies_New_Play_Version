package models

import play.api.data.Form
import play.api.data.Forms._

case class People(name: String, phone: String, email: String, comments: String) {

  override def toString() = s"Name: $name <br> Phone number: $phone \n\r Email: $email \n\r Comments: $comments"
}

object People {
  val createPeopleForm: Form[People] = Form(
    mapping(
      "name" -> nonEmptyText,
      "phone" -> nonEmptyText,
      "email" -> nonEmptyText,
      "comments" -> text
    )(People.apply)(People.unapply)
  )
}

