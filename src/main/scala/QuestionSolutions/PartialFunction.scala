package QuestionSolutions

object PartialFunction extends App {

  val aPartialFuncton: PartialFunction[Int, Int] = {
    case 1 => 42
    case 2 => 44
    case _ => 55
  }

  println(aPartialFuncton(1))
  println(aPartialFuncton(5))
  println(aPartialFuncton.isDefinedAt(67))

  val lifted = aPartialFuncton.lift // it default use option . sample is Int => Option[Int]
  println(lifted(555))
  println(lifted(5))

  // Partial Functon chaining
  val pfchain = aPartialFuncton.orElse[Int, Int] {
    case 45 => 66
  }
  println(pfchain(2))
  println(pfchain(45))

  val aMappedList = List(1, 2, 3).map {
    case 1 => 44
    case 2 => 34
    case 3 => 4567
  }
  // it will return a list of output // it also cause pattern match error if any one element is not found.
  println(aMappedList)

  // Exercise No 1
  val aManualFussyFunction = new PartialFunction[Int, Int] {
    override def apply(v1: Int): Int = v1 match {

      case 1 => 34
      case 2 => 344
      case 3 => 555
    }

    override def isDefinedAt(x: Int): Boolean = {
      x == 1 || x == 2 || x == 3
    }
  }

  println(aManualFussyFunction(1))
  println(aManualFussyFunction.isDefinedAt(6))
}
