package part1_scalaBasics

object L3_Expressions extends App {
  val x = 1 + 2
  println(x)
  println(2 + 3 * 4) // Math Expressions
  // Math Operations are : + _ * / & ^ << >> >>>(right shift with zero extension)
  println(1 == x) // == != > < >= <=

  println(!(1 == x)) // logical negation

  var aVariable = 2
  aVariable += 2 // also works with -= *= /= ... side effects(changing a variable is a side effect)
  println(aVariable)


  // Instruction vs Expressions
  /**
   *  1. Instruction (Do) - like java,Python - we code something to do some task
   *
   * 2.  Expression - something which have a value or type -> every single bit of code will compute a value.
   *
   * eg IF expressions
   *
   */
  val aCondition = false
  val aConditionValue = if (aCondition) 5 else 3
  println(aConditionValue)
  println(if (aCondition) 53 else 22)


  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // NEVER WRITE THIS IN THIS WAY AGAIN

  // EVERYTHING IN SCALA IS AN EXPRESSION

  val aWeiredValue = (aVariable = 3) // unit == void   // side effect in scala is actually expression returning units...
  println(aWeiredValue+" something weired happened here....")

  // Side Effects : println(), Whiles, reassigning

  // code block is an expression...
  val aCodeBlock = {
    val y = 3
    val z = y + 1
    if (z > 2) "hell0" else "bye"
  }

  println(aCodeBlock)

  val someValue = {
    2 < 3
  }
  println(someValue)

  // 42 is basic value for the code block
  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
  println(someOtherValue)

}
