package QuestionSolutions

object FindMaximum extends App {
  def findMax(numbers: List[Int]): Any = {
    numbers.max
  }

  // Test the function
  val inputList = List(3, 7, 1, 9, 5)
  val result = findMax(inputList)
  println(s"The maximum element is: $result")
}
