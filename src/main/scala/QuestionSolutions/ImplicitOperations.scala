package QuestionSolutions

object ImplicitOperations extends App {

  val aTuple = (1,2)
  val aPair = 1 -> 2

  println(aTuple._1+ " "+ aTuple._2)
  println(aTuple)
  println(aPair)

  implicit def check(str : String) = str

  implicit def check(int : Int) = "printing the taken value : "+int

  implicit def check(d : Double) = "printing double value : "+d


  println(check("dee"))
  println(check(22))
  println(check(33.33))

  def increment(x : Int)(implicit amount : Int) = x + amount
  implicit val defaultAmount = 10
  println(increment(2))

}
