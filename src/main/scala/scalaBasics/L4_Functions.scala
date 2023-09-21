package scalaBasics

object L4_Functions extends App {

  // defination function_name(prameters ) : return type = Expression
  def aFunction(a: String, b: Int): String = { // function is for string concatenation
    a + " " + b
  };
  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction) // a function without parameter can be also called with name only...



  // Whenever you need loop use recursive function
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }
  print(aRepeatedFunction("hello", 3))

// Side Effects Function
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  /*
  These observable actions or side effects can include things like printing to the console,
  modifying global variables, writing to files, making network requests, or altering the
  state of mutable data structures.
   */

}
