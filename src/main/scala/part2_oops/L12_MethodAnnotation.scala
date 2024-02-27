package part2_oops

import scala.language.postfixOps

object L12_MethodAnnotation extends App {

  class Person(val name: String, favoriteMovie : String){
    def likes(movie : String) : Boolean = movie==favoriteMovie
    def hangOutWith(person : Person) : String = s"${this.name} is hanging out with ${person.name}"
    def +(str : String): String = s" how was ${str}" // we can define methods using operators as well
    def unary_! : String = s"${name} what the heck"

    def isAlive : Boolean = true
    def apply() : String = s"Hi $name i know your favorite movie is $favoriteMovie"
    def check() : String = s"hi buddy"
  }
  //********************************************************************
  val mary = new Person("mary","IWEYP")
  // Both below methods are equivalent
  println(mary.likes("IWEYP"))  //
  // infix notation = operator notation = (syntactic sugar <more close to natural language>)
  println(mary likes "IWEYP") // only applicable with single parameter methods.

  val tom = new Person("tom","GOFF")
  println(mary hangOutWith tom)

  println(tom + "harry")
  println(tom.+("harry"))

  val x = -1
  val y = 1.unary_- // unary_prefix only works with - + ~ !
  println("value of y is : "+y)

  println(!mary)
  println(mary.unary_!)

  // --- without parameter function call

  println(mary.isAlive)
  println(mary isAlive)

  println(mary.apply())
  println(mary()) // it always search for the apply() method on call/

}

