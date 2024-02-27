package QuestionSolutions

object PatternMatching extends App {

  case class Person(name: String, age: Int)

  val temp = Person("N1", 25)
  val res = temp match {
    case Person(nameddd, agdde) => if (agdde > 30) s"Hi i am $nameddd" else "who are you?"
    case _ => "Something wrong happened..."
  }

  println(res)

  val aTuple = ((1, 2), (3, 4), (5, 6))

  val result = aTuple match {
    case ((_, 1), (4, 5), (6, 6)) => "got the required output..."
    //  case ((_, _),(_,_),(_,_)) => "i got something..."
    case ((a, b), (c, d), (e, f)) => s"i got something like (($a,$b),($c,$d),($e,$f))..."
  }

  println(result)

  val aStandardList = List(1, 2, 3, 42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => "list is starting form 1..."
    case 1 :: _ => "Infix done here..."
    //    case List(1,_*) => "list is starting from 1 again..."
  }
  println(standardListMatching)

  println("-------------------------------------------------------------------------")

  // 6 - type specifier
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => //explicit type specifier
    case _ =>
  }
  println(unknown)

  val test = try{
  // Code
    throw new RuntimeException()
  }
  catch {
    case e : RuntimeException => "Runtime..."
    case npe : NullPointerException => "null pointer exception..."
    case _ => "Something we don't know"
  }

  println(test)
}