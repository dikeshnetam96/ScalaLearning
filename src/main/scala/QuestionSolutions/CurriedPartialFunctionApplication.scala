package QuestionSolutions

object CurriedPartialFunctionApplication extends App {

  def superAdder(x : Int)(y : Int) : Int = x + y

  val superAdd : Int => Int => Int = x => y => x+y
  val mid = superAdder(4)(6)
  println(mid)

  val addtwotime = (x : Int) => (y : Int) => x + y

  val mid2 = superAdder(4) _
  println(mid2(6))

  def concatenator(a: String, b: String, c: String) = a + b + c

  val insertName = concatenator("Hello I'm ", _: String, " how are you!") // making compiler to write an ETA Funtcions
  println(insertName("xyz")) // x : String => concatenator("hello",x,"how are you!")

  val insertTwoValues = concatenator("Hello I'm ", _: String, _: String)
  println(insertTwoValues(" xyz ", " and you are my friend.."))
  val test = insertTwoValues("dikesh", _: String)
  println(test(" and you are my friends"))
}
