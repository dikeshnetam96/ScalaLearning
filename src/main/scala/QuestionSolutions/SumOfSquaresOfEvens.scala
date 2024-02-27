package QuestionSolutions

object SumOfSquaresOfEvens extends App {

  def sumOfSquaresOfEvens(numbers: List[Int]): Int = {
    numbers.filter(x => x%2 == 0).map(x=>x*x).sum
  }

  val inputList = List(1, 2, 3, 4, 5, 6)
  val result = sumOfSquaresOfEvens(inputList)
  println(s"The sum of squares of even numbers is: $result")

}
