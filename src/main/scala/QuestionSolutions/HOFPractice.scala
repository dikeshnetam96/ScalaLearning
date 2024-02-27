package QuestionSolutions

object HOFPractice extends App {

  //  1st Problem
  val square: Int => Int = (x: Int) => x * x
  val cube: Int => Int = (x: Int) => x * x * x

  def applyOperation(i: Int, intToInt: Int => Int): Int = intToInt(i)

  println(applyOperation(5, square)) // Output: 25
  println(applyOperation(3, cube)) // Output: 27

  // 2nd Problem
  // Usage
  val isEven: Int => Boolean = (x: Int) => x % 2 == 0
  val isPositive: Int => Boolean = (x: Int) => x > 0

  def filterElements(value: List[Int], intToBoolean: Int => Boolean) = value.filter(intToBoolean)

  val numbers = List(1, -2, 3, -4, 5, 6, -7, 8, 9)
  println(filterElements(numbers, isEven)) // Output: List(-2, -4, 6, 8)
  println(filterElements(numbers, isPositive)) // Output: List(1, 3, 5, 6, 8, 9)

  // 3rd question

  def addCurried(x: Int)(y : Int) : Int = x + y
  val addPartiallyApplied: Int => Int = addCurried(5)
  println(addPartiallyApplied(3)) // Output: 8

  // 4th Problem
  def concatCurried(str: String, str1: String)(str2 : String) = str+str2+str1

  // Usage
  val concatenateWithSpace: String => String = concatCurried("Hello", "World")
  println(concatenateWithSpace(" ")) // Output: Hello World

  // 5th Super Adder
  val superAdder = (x : Int) => (y : Int) => x + y
  val superAdder2 = (x : Int) => x
  println("Test" + superAdder2(5))
  val add = superAdder(4)
  val res = add(4)
  println(res)

}
