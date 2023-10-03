package part3_functionalProgrammingInScala

object L25_WhatAFunction extends App {

  // Dream : use functions as first class elements
  // Problem : oops

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types = Function1[A,B]
  // scala supports this function type parameters upto 22 parameters.

  val stringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("3") + 4)
  //                                         [Input1,Input2 Output]
  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    //: ((Int,Int) => Int) This is syntactic sugar for function 2
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  trait MyFunction[A, B] {
    def apply(element: A): B
  }

  // Function type Function2[A,B,R] == (A,B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
    1. a function which takes 2 strings and concatenates them
    2. transform the MyPredicate and MyTransformer into function types
    3. define a function which takes an int and return another function which takes an int and returns an int
        - what's the type of this function
        = how to do it
   */

  /*
  Higher Order Parameters : It either receives functions as parameters and return other function as result.
   */

  def concaternator: (String, String) => String = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(concaternator("Hello", " Scala!"))

  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))

  println(superAdder(3)(4)) // Curried Function

}
