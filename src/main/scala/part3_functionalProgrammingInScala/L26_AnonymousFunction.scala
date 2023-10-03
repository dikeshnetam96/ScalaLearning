package part3_functionalProgrammingInScala

object L26_AnonymousFunction extends App {

  // Anonymous Function are Basically Lambda
  //  val doubler : Int => Int = (x : Int) => x*2
  // val doubler: Int => Int = x => x * 2
  val doubler = (x: Int) => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  println(justDoSomething) // function itself
  println(justDoSomething()) // this is call
  println(doubler(5))
  println(adder(3, 4))

  // Curly nraces with lambdas
  val stringToInt = { (str: String) => str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x+1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a+b

  /*
  1. MyList : replace all FunctionX calls with lambdas
  2. Rewrite the "special" adder as an anonymous function
   */

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))

}
