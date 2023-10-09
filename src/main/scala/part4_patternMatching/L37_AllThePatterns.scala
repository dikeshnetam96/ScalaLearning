package part4_patternMatching

import part3_functionalProgrammingInScala.L31_Sequences.aList
import part3_functionalProgrammingInScala.{Cons2, Empty2, MyList2}

object L37_AllThePatterns extends App {

  // 1 - constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a match"
    case "Scala" => "This Scala"
    case true => "The Truth"
    case L37_AllThePatterns => "A singleton Object"
  }
  println(constants)

  // 2 - match anything
  // 2.1 - wildcard
  val matchAnyThing = x match {
    case _ => "matched anything..."
  }
  println(matchAnyThing)

  // 2.2 variable
  val matchAVariable = x match {
    case something => s"I've found $something"
  }
  println(matchAVariable)

  // 3 - tuple
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"I've found $something"
  }
  println(matchATuple)

  /*  // nested tuples
    val nestedTuples = (1, (2, 3))
    val matchANestedTuples = x match {
      case (_,(2,v)) => "hii"
    }*/

  //Pattern Matching can be Nested

  // 4 - case classes - constructor pattern
  // PM can be nested with CCs as Well


  // 5 - list Patterns

  val aStandardList = List(1, 2, 3, 42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => println("found the List") // extractor - advanced
    case List(1, _*) => // list of arbitrary length - advanced
    case 1 :: List(_) => //infix pattern
    case List(1, 2, 3) :+ 42 => //infix pattern
  }
  println(standardListMatching)

  // 6 - type specifier
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => //explicit type specifier
    case _ =>
  }
  println(unknownMatch)

/*  // 7 - name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons2(_,_) => // name binding => use the name later(here)
    case Cons(1, rest @ Cons2(2,_)) => // name binding inside nested patterns
  }*/

  /*
  // 8 - multi patterns
  val multiPattern = aList match {
    case Empty2 | someMethod => // Compound Pattern (Multi Pattern)
    // this line helps us to give same output for multiple cases
  }*/

/*  // 9 - If Guards
  val secondElementsSpecial = aList match {
    case Cons(_, Cons(specialElement),_) if specialElement % 2 ==0 =>
  }*/

  val number = List(1,2,3)
  val numberMatch = number match {
    case listOfString : List[String] => "a list of String"
    case listOfInteger : List[Int] => "a list of Integer"
    case _ => ""
  }
  println(numberMatch) // it's output is "a list of String" because of JVM it check the type and and done.
    // works in such a fashion which is mentioned below :
  /*
  val number = List(1,2,3)
  val numberMatch = number match {
    case listOfString : List => "a list of String"
    case listOfInteger : List => "a list of Integer"
    case _ => ""

    // Here it just check the List and return the first statement
   */
  val newList = number:+"hi"
  print(newList)
}
