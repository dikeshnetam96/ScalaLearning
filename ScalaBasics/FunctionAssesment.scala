package ValuesVariableTypes

object FunctionAssesment extends App{
/*
1. A greeting function (name,age) => ""Hi, my name is "+name+" and i am "+age+" years old."
2. Factorial function 1 * 2 * 3.. * n
3. A Fibonacci function
   f(1) = 1
   f(2) = 2
   f(3) = f(2)+f(1)
   f(n) = f(n-1) + f(n-2)

4. Test if a number is prime.
 */

  // Assignment 1 : A Greeting Function
  def greetingFucntion(name:String , age : Int) : Unit = { // Unit= void
    println("Hi, my name is "+name+" and i am "+age+" years old.")
  }
  greetingFucntion("XYZ",25)

  // Assignment 2 :  factorial of number
  def factorialFunction(n:Int): Int ={
    if(n==1) 1
    else n*factorialFunction(n-1)  // multiplying the current no with previous no.
  }
  println(factorialFunction(4))

  // Assignment 3 : Check prime number or not
  def primeChecking(n : Int) : Boolean = {
    if(n==1 || n==2) true
    val temp = n/2
    // This function is check all lesser number than n/2 can divide the n, if so then it will not be a prime otherwise it will be prime.
    def check(temp : Int): Boolean = {
      if(temp<=1) return true
      if(n%temp==0) return false
      else check(temp-1)
    }
    check(temp)
  }
  println(primeChecking(407)) // calling prime checking function for number 407.

  def fab( n : Int): Int = {
    if(n<=2)
      1
    else
      fab(n-1)+fab(n-2) // adding previous two numbers find current index's number.
  }
  println(fab(5)) // calling fabonnacciFunction to find fabonnacci number of index 7
}
