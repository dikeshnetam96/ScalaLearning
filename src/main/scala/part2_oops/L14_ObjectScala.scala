package part2_oops

object L14_ObjectScala extends App {

  /*
  Companion Object : it is extension of singleton object

  - when we define object and class with same in a single source file then it will be
    companion of each other.

    Why?
    - Separation of concern using a companion
    - Implementation Factory Method or a Builder Pattern

    separation of concerns -->
    class- Non static variables
    object - static variables (scala don't allow to create static method and static value in a class)
   */

  object cls {
    var num = 4
    def apply(str: String): String = "hiii"
  }

  class cls(str: String) {
    val num = 5
  }

  // This will create reference to singleton object
  val obj1 = cls
  val obj2 = cls

  obj1.num = 5
  println(obj1.num)
  println(obj2.num)

  println(obj1)
  println(obj2)
  println(obj1 == obj2)

  // This will create object which is not singleton
  val obj3 = new cls("abc")
  val obj4 = new cls("xyz")

  println(obj3)
  println(obj4)

  println(obj1("hi"))
}
