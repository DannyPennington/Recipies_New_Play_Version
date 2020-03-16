package models

import play.api.data.Form
import play.api.data.Forms._

case class CD(name: String, price: BigDecimal) {
  override def toString = s"The name of the CD is: $name and the price is £$price"
}

object CD {
  val createCDForm: Form[CD]= Form(
    mapping(
      "name" -> nonEmptyText,
      "price" -> bigDecimal
    )(CD.apply)(CD.unapply)
  )
}