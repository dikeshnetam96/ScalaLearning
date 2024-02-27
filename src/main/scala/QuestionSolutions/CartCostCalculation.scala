package QuestionSolutions

object CartCostCalculation extends App {

  case class Cart(productName: String, price: Double)

  def calculateTotalCost(list: List[Cart]): Double = {
    list.map(x => x.price).sum
  }

  val list: List[Cart] = List(Cart("pen", 10), Cart("geometryBox", 10), Cart("scale", 20), Cart("copy", 60))
  println(calculateTotalCost(list))

}
