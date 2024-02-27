package QuestionSolutions

object MapFilterForComprehension extends App {

  val list : List[Double] = List(2.4,4,4.7,7.9,5.3,3)
  println(list.map(x => x * 2))

  val words = List("Hello", "World")
  val newWords = words.flatMap(word => word.distinct)

  // for - comprehension

  val list1 = List(1, 2, 3)
  val list2 = List('a', 'b')

  val test = for {
    x <- list1
    y <- list2
  } yield (x, y)

  println(test)
}
