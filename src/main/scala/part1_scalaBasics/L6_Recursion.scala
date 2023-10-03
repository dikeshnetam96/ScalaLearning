package part1_scalaBasics

import scala.annotation.tailrec

object L6_Recursion extends App {

  // Writing factorial function

  // Memory is occupied in each call
  /*  def factorial(n:Int):Int={
      if(n<=1) 1
      else {
        println("computing factorial of "+n+" first need factorial of "+(n-1))

        val result = n*factorial(n-1)
        println("computed factorial of "+ n)
        result
      }
    }
    factorial(5000)  // it will crash due memory limit of stack
    */

  // Factorial Memory efficient program
  def fact(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, acc: BigInt): BigInt = {
      if (x <= 1) acc
      else factHelper(x - 1, x * acc) // TAIL RECURSION = Use recursive call as the last expression
    }

    factHelper(n, 1)
  }
  // println(fact(5000))
  println(fact(5))
  println("--------------------------------------------------------")

  // Writing string concatenation function using tail recursion
  println("concatenate a string n time")

  def stringConcateFuncton(n: Int, str: String): String = {
    @tailrec
    def helperConcate(n: Int, str: String, res: String): String = {
      if (n <= 0) res
      else helperConcate(n - 1, str, res.concat(str)) // calling function n times and concatenating string(str) in each call
    }

    helperConcate(n, str, "")
  }
  println(stringConcateFuncton(5, "name "))
  println("----------------------------------------------------------")

  // writing prime number function using tail recursion
  println("IsPrime function tail recursion")
  /*  // my code
  def numberIsPrime(n:Int) : Boolean = {
    @tailrec
    def helper(n:Int,count:Int):Boolean = {
      if(count<=1)
        true
      else
        n%count!=0&&helper(n,count-1)
    }
    helper(n,n/2)
  }
  println(numberIsPrime(13732))*/

  def isPrime(n: Int): Boolean = {
    @tailrec
    def tailIsPrime(num: Int, x: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime)
        false
      else if (x <= 1) true
      else tailIsPrime(num, x - 1, (num % x != 0))
    }

    tailIsPrime(n, n / 2, true) // it will check recursively, n is divisible by n/2 or any lower value of n/2.
  }

  println(isPrime(51))

  println("----------------------------------------------------------")

  // Writing fabonacci functon using tail recursion
  println("Fabonacci function ")

  private def fabonacciByIndex(n: Int): BigInt = {
    @tailrec
    def helper(n: Int, acc: BigInt, prev: BigInt): BigInt = {
      if (n <= 2) acc
      else helper(n - 1, acc + prev, acc) //fabonacciByIndex(n - 1) + fabonacciByIndex(n - 2)
    }
    helper(n, 1, 1)
  }

  println(fabonacciByIndex(3))
} // 1 1 2 3 5 8 13 21
// 1 2 3 4 5 6  7  8 9
