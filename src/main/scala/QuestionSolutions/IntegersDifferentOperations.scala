package QuestionSolutions

object IntegersDifferentOperations extends App {

  /*
   Write a function to process a list of integers using pattern matching.
   */
  case class IntegerAndOperations(operation: String, numbers: List[Int])

  /*
    def getSum(obj : IntegerAndOperations) : Int = obj.numbers.sum
    def getDoubleList(obj : IntegerAndOperations) : List[Int] = obj.numbers.map(x => x * 2)
    def getEvemNumList(obj : IntegerAndOperations) : List[Int] = obj.numbers.filter(x => x%2==0)
  */

  def evaluate(obj: IntegerAndOperations): List[Int] = {
    obj.operation match {
      case "sum" => List(obj.numbers.sum)
      case "double" => obj.numbers.map(x => x * 2)
      case "evenNumbers" => obj.numbers.filter(x => x % 2 == 0)
      case _ => List()
    }
  }

  val list1 = IntegerAndOperations("sum", List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
  val list2 = IntegerAndOperations("double", List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
  val list3 = IntegerAndOperations("evenNumbers", List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
  val list4 = IntegerAndOperations("subs", List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

  println(evaluate(list1))
  println(evaluate(list2))
  println(evaluate(list3))
  println(evaluate(list4))
}
