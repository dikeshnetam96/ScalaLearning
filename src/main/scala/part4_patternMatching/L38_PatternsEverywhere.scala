package part4_patternMatching

object L38_PatternsEverywhere extends App {

  // big idea #1
  try {
    // code
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "null pointer exception"
    case _ => "something we don't know"
  }

  // catches are actually Matches
  /*

  try {
    // code
  } catch(e) {
  e match {
     case e : RuntimeException=> "runtime"
     case npe : NullPointerException=> "null pointer exception"
     case _ => "something we don't know"
  }
  }
   */


  // big idea #2
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield 10 * x

  // generators are also based on Pattern Matching
  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second
  // case classes, :: operators, ...

  // big idea #3
  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  println(a)
  // multiple value definitions based on PATTERN MATCHING
  // ALL THE POWER

  val head :: tail = list // head and tail going to bind member of list
  println(head)
  println(tail)

  // big idea #4 - NEW
  // partial function

  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
  } // partial function literal

  val mappedList2 = list.map { x => x match {
      case v if v % 2 == 0 => v + " is even"
      case 1 => "the one"
      case _ => "something else"
    }
  }
  println(mappedList2)
}
