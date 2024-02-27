package QuestionSolutions


trait Calculator {
  def calculate(a: Int, b: Int): Int
}

object AnonymousClassQuestions extends App {

  // Create an instance of the Calculator trait using an anonymous class for addition

  val additional : Calculator = new Calculator {
    override def calculate(a: Int, b: Int): Int = a + b
  }

  // Perform addition using the anonymous class
  println(additional.calculate(4,5))

  val substraction : Calculator = new Calculator {
    override def calculate(a: Int, b: Int): Int = a - b
  }

  // Perform Substraction
  println(substraction.calculate(5,2))

  val multiply : Calculator = new Calculator {
    override def calculate(a: Int, b: Int): Int = a*b
  }

  // Perform Multiplication
  println(multiply.calculate(3,4))

  val divide : Calculator = new Calculator {
    override def calculate(a: Int, b: Int): Int = a/b
  }

  // Perform Division
  println(divide.calculate(6,2))

}
