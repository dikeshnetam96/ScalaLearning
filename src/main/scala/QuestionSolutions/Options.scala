package QuestionSolutions

object Options extends App {

  val scores: List[Option[Int]] = List(Some(85), Some(90), None, Some(78), None, Some(92))

  // Your code here

  // Expected result: 86.25
  println(scores)
  val validScores: List[Int] = scores.flatten // Removes None values and extracts the Int values
  println(validScores)
  val averageScore: Option[Double] = if (validScores.nonEmpty) Some(validScores.sum.toDouble / validScores.length) else None

  averageScore.foreach(println)


}
