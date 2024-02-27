package QuestionSolutions

object PatternMatchingSamples extends App {

  val aStandardList = List(1, 2, 3, 42)
  val aStandardList2 = List(1, 2, 3)
  val aStandardList3 = List(4,1, 2)
  val standardListMatching = aStandardList2 match {
    case List(1, _, _, _) => "found the List" // extractor - advanced
    case List(1, _*) => "arbitrary list found here"// list of arbitrary length - advanced
    case 4 :: List(_) => "Some random list" //infix pattern
    case List(1, 2, 3) :+ 42 => "added 42 in the list"//infix pattern
  }
  println(standardListMatching)

}
