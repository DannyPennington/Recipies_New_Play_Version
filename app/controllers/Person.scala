package controllers

class Person(name:String, age:Int) {
  def show():String = {
    s"Name: $name , Age: $age"
  }
}
