package part3_functionalProgrammingInScala

object L27_HOFsCurries extends App {

  /*
  Return type of this below function is another function which is having input as int and output as int.

  Higher Order Function (HOF) : Such functions with take functions as parameters and result function as output.


   */

  // Make sure to replace the implementation with your actual logic according to your requirements.
  // val superFunction : (Int,(String, (Int => Boolean))=>Int) => (Int,Int) = ???
  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int, Int) = null // changed this to null to avoid NotImplementedError

  // Higher Order Function (HOF)
  // map, flatmap, filter in MyList which we have already written are HOFs

  // function that applies n times over a value x
  // nTimes(f, n, x)  // f - function, n - number , x - value
  // nTimes(f,3,x) = f(f(f(x))) = nTimes(f,2,f(x)) = nTimes(f,1,f(f(x))) = f(f(f(x)))

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }

  /*
  plusOne is a variable that holds a function that performs the operation of adding one to its input.
  You can later use plusOne like any other function to increment an integer value by one.
   */
  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  /*
  This below function takes function and integer as input parameter and return a function as output parameter
   */
  def nTimesBetter(f : (Int=>Int),n: Int) : (Int=>Int) = {
    if(n<=0) (x : Int) => x
    else (x : Int) => nTimesBetter(f,n-1) (f(x))
  }

  val plus10 = nTimesBetter(plusOne,10)
  println(plus10(3))

  // Curried Functions
  val superAdder = (x : Int) => (y : Int) => x+y
  val add3 = superAdder(3) // y=> 3+y
//  println(add3) // as previously we have seen this variable also contains function which can be further used with input parameter as shown below.
  println(add3(10))

  // functions with multiple parameter lists
  def curriedFormatter(c : String)(x : Double) : String = c.format(x)

  // In smaller function, need to be specified their parameters.
  val standardFormate : (Double => String) = curriedFormatter("%4.2f")
  val preciseFormate : (Double => String) = curriedFormatter("%10.8f")

  println(standardFormate(Math.PI))
  println(preciseFormate(Math.PI))



}
