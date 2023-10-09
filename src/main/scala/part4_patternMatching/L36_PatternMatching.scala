package part4_patternMatching

import scala.util.Random

object L36_PatternMatching extends App {

  // switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "One"
    case 2 => "Two"
    case 3 => "Three"
    case _ => "Something else" // _=WILDCARD
  }

  println(x)
  println(description)

  // 1. Decompose value
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 25)

  val greeting = bob match {
    case Person(n, a) if a < 26 => s"Hi i'm $n and I am $a years old."
    case _ => "I don't know"
  }
  println(greeting)

  /*
  1. cases are matched in order
  2. what if no cases match?
  3. type of the PM Expressions? unified type of all the types in all the cases
  4. PM works really well with case classes
   */

  // PM on sealed hierarchies

  sealed class Animal

  case class Dog(breed: String) extends Animal

  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")

  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
  }

  // match everything

  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }

  //WHY?
  val isEvenCond = if (x % 2 == 0) true else false
  val isEvenNormal = x % 2 == 0

  /*

    Exercise
    simple function uses PM
      takes an Expr => human readable form

      sum(Number(2), Number(3)) => 2+3
      sum(Number(2), Number(3),Number(4)) => 2+3+4
      Prod(Sum(Number(2),Number(1)),Number(3)) = (2+1)*3
      Sum(Prod(Number(2),Number(1)),Number(3)) = 2* 1 + 3
   */

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e : Expr) : String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " +  " + show(e2)
    case Prod(e1, e2) => {
      def mayBeShowParanthesis(exp : Expr) = exp match {
        case Prod(_,_) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }
      mayBeShowParanthesis(e1) + " * " + mayBeShowParanthesis(e2)
    }
  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)),Number(4))))
  println(show(Prod(Sum(Number(2),Number(1)),Sum(Number(5),Number(6)))))
  println(show(Sum(Prod(Number(2),Number(1)),Number(3))))
}

