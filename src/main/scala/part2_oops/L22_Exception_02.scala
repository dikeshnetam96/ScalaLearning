package part2_oops

object L22_Exception_02 extends App {

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


  // 1. Crash Your program using OutOfMemoryError
  /*
  // We need to add this line for it.
  throw OutOfMemoryError*/

  // 2. Crash Your Program with StackOverflowError
  /*  // We Need to add this line for StackOverFlowError
    throw StackOverflowError*/

  class Calculator {

    def add(num1: Int, num2: Int): Int = {
      if((num1+num2)>Int.MaxValue) throw new ArithmeticException("Overflow Error")
      else (num1+num2)
    }

    def substract(num1: Int, num2: Int): Int = {
      if((num1 - num2)<Int.MinValue) throw new ArithmeticException("UnderFlow Error")
      else (num1-num2)
    }

    def multiply(num1: Int, num2: Int): Int = {
      if((num1*num2)>Int.MaxValue) throw new ArithmeticException("Overflow Error")
      else
        num1*num2
    }

    def divide(num1: Int, num2: Int): Float = {
      println(num2)
      println(num2 == 0)
      if (num2 == 0)
        throw new ArithmeticException("Found a Division operation with 0")
      else
        num1 / num2
    }

  }

  val calcObj = new Calculator()

  println(calcObj.add(3, 4))
  println(calcObj.substract(2, 4))
  println(calcObj.multiply(2, 4))
  println(calcObj.divide(4, 2))

/*
  Arithmatic Exception
  println(calcObj.divide(4, 0))
*/


}
