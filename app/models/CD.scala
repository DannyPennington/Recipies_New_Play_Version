package models

import play.api.data.Form
import play.api.data.Forms._

case class CD(name: String, price: Int) {
  override def toString() = s"The name of the CD is: $name and the price is $price"
}

object CD {
  val createCDForm = Form(
    mapping(
      "name" -> nonEmptyText,
      "price" -> number
    )(CD.apply)(CD.unapply)
  )
}