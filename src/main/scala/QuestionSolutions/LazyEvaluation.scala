package QuestionSolutions

object LazyEvaluation extends App {

  // lazy - will make computation once(it won't compute again [more or less like static]), only when it is needed
  lazy val test: Int = {
    println("hello")
    42
  }

  println(test)

  println("printing already computed values : " + test)

  def sideEffectCondition: Boolean = {
    println("Boo")
    true
  }
  println(sideEffectCondition)

  def callByName(x : Long) = {
    println(x)
    println(x)
  }

  def callByValue(x : => Long) = {
    println(x)
    println(x)
  }

  callByName(System.nanoTime())
  callByValue(System.nanoTime())

  lazy val expensiveComputation: Int = {
    println("Computing...")
    42
  }

  // The expensive computation is not executed until the first access
  val result1 = expensiveComputation // Prints "Computing..."
  val result2 = expensiveComputation // Does not print "Computing..."
  println(result1+" "+result2)

}
