package part2_oops

import scala.language.postfixOps

object L13_MethodAnnotation_Exercise extends App{

  /*
  Assignment :

  1. Overload the + operator
     mary + "the rockstar" => new Person "Mary (the rockstart)"

  2. 2.1 Add an age to the Person class
     2.2 Add a unary + Operator => new person with the age + 1
     2.3 +mary => mary with the age increment

  3. 3.1 Add a "learns" method in the Person Class => "Mary learns Scala"
     3.2 Add a learnScala Method, calls learns method with Scala
     3.3 Use it in Postfix notation

  4. Overload the apply method
     mary.apply(2) => "Mary Watched Inception 2 times"

   */

  // Problem 2.2
  class Person(val name:String, val favoriteMovieName : String,val age : Int) {
    // Problem No. 1
    def +(str : String) : Person = new Person(s"${name} (${str})",favoriteMovieName,age)
    //Problem No. 2.1
    def unary_+ : Person = new Person(name,favoriteMovieName,age+1)
    // Problem 3.1
    def learns(str : String) : String = s"$name learns $str"
    // Problem No
    // Problem 3.2
    def learnScala : Unit = println(learns("Scala"))

    // Problem No 4
    def apply(num : Int) :String = s"$name watched inception $num times"
  }

  val mary = new Person("mary","Inception",25)
  var newMary = mary + "the rockstar"
  println(newMary.name + " "+newMary.favoriteMovieName+" "+newMary.age)

  newMary = newMary.unary_+
  println(newMary.name + " "+newMary.favoriteMovieName+" "+newMary.age)

  // Problem No. 2.3
  newMary = +newMary
  println(newMary.name + " "+newMary.favoriteMovieName+" "+newMary.age)

  // Problem 3.3
  println(newMary.learns("Automation Testing"))
  newMary learnScala

  // Problem No. 4
  println(newMary(2))
}
