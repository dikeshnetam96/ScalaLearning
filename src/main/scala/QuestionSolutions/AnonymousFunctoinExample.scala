package QuestionSolutions

// It is lambda expression....
object AnonymousFunctoinExample extends App {

  val add: (Int, Int) => Int = (x, y) => x + y
  val square: Int => Int = (x) => x * x
  val multiply: (Int, Int) => Int = (x, y) => x * y

  println("adding two numbers : "+ add(4,5))
  println("squar numbers : "+ add(4,5))
  println("adding two numbers : "+ add(4,5))
}
