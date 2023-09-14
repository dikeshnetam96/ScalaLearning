package ValuesVariableTypes

object ValuesVariablesTypes extends App {  // extends helps to run in ide.... #IDK

  // val type variable is immutable
  private val x = "Hello!!"
  println(x)

  // below mentioned two declarations are used for creating immutable variable which contains string value.
  val aString : String = "testing";
  val anotherString = "started"
  println(aString+" "+anotherString)

  // declaration of different immutable data type
  val aBoolean : Boolean = false
  val aChar : Char = 'a'
  val anInt : Int = 3
  val aShort : Short = 4343
  val aLong : Long = 3223L // 8 byte
  val aFloat : Float = 2.0f
  val aDouble : Double = 3.14


  // var is mutable
  var aVariable : Int = 4
  aVariable = 5
  print(aVariable)

   var y = "test"
  y = "modifiedtest"

  // String Interpolation used to print variable value.
  println(s"after modification of y : $y")

}
