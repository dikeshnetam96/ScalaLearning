package part4_patternMatching

object L39_BracelessSyntax {

  // if - expressions
  val anIfExpression = if (2 > 3) "bigger" else "smaller"

  // java style
  val anIfExpression_v2 =
    if (2 > 3) {
      "bigger"
    }
    else {
      "smaller"
    }

  //compact
  val anIfExpression_v3 = {
    if (2 > 3) "bigger"
    else "smaller"
  }
/*
// I have written below code for scala 3, it will create problem in lower version of scala...

val anIfExpression = if 2 > 3 then "bigger" else "smaller"

val anIfExpression_v4 =
  if 2 > 3 then
    "bigger" // higher indentation than the if part
  else
    "smaller"

val aForComprehension = for {
  n <- List(1, 2, 3)
  s <- List("black", "white")
} yield s"$n$s"

// scala 3  // only need to take care of some indentation
val aForComprehension_V2 =
  for
    n <- List(1, 2, 3)
    s <- List("black", "white")
  yield s"$n$s"

// pattern matching
val meaningOfLife = 42

val aPatternMatch = meaningOfLife match {
  case 1 => "the one"
  case 2 => "double or nothing"
  case _ => "something else"
}

val aPatternMatch2 = meaningOfLife match
  case 1 => "the one"
  case 2 => "double or nothing"
  case _ => "something else"

// methods without braces   // Taking care of indentation is necessary
def computeMeaningOfLife(arg: Int): Int =
  val partialResult = 40
  partialResult + 2

// we can also define call, enum ,etc.. like that only
// class defination with significant indentation (same for traits, objects, enums etc)

class Animal:
  def eat(): Unit =
    print("I'm Eating")
  end eat // Note : Use it when you code is more than 4 lines.

  def grow(): Unit =
    println("I'm Growing")
  end grow

  // 3000 more lines of code
end Animal // this is end token which says that method/class ends here
// we can use this for if, match, for, methods , classes, traits, enums, objects

val aSpecialAnimal = new Animal:
  override def eat(): Unit = println("I'm the one who is eating")

// indentation = strictly larger indentation
//

*/



  def main(args: Array[String]): Unit = {

    println(anIfExpression_v3)
    /*
    for scala 3 functions

    println(anIfExpression)
    println(anIfExpression_v4)
    println(aForComprehension)
    println(aForComprehension_V2)
    println(computeMeaningOfLife(5))
     */

  }

}
