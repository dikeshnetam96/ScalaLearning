package part2_oops

object L23_Exceptions extends App {
  val x: String = null
  println(x)

  // throwing a Exception here intentionally
  // val aWeiredValue : String = throw new Exception()

  // throwable classes extend the Throwable class.
  // Exception(NullPointerException etc..) and Error(problem with system) are the major Throwable subtypes

  // 2. How to Catch Exception
  def getInt(withException: Boolean): Int = {
    if (withException) throw new RuntimeException("No int for you!")
    else 42
  }
// Now potentialFail is of type Int here, because getInt function return int and catch also return int.
   val potentialFail = try {
    // code that might throw
    getInt(false)
  }
  catch {
    case e : RuntimeException => 43//println("Cought a Runtime Exception")
  }
  finally {
    // code that will execute NO MATTER WHAT
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("Finally Function Executed...")
  }

  println(potentialFail)

/*  def double: Int =>  Int = (x) => x * 2
  val test = double(5)
  println(test)*/


  // 3. How to define your own Exception
  // (Exceptions : Exceptions are instances of special classes which are derived from exception or errors)

  class MyException extends Exception
    val exception = new MyException()

  throw exception

  /*
  1. Crash your program using outOfMemoryError
  2. Crash with stackOverflow Error
  3. Define little calculator
      - add(x,y)
      - subtract(x,y)
      - divide(x,y)
      - multiply(x,y)

  Throw
      - OverflowException if add(x,y) exceed Int.MAX_VALUE
      - UnderflowException if subtract(x,y) exceed the Int.MIN_VALUE
      - MathCalculationException for division by 0

   */


}
