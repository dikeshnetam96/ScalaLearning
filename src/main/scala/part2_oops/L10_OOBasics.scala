package part2_oops

object OOBasics extends App {
  val person = new Person("john", 26)
  println(person)
  // print(person.name)
  println(person.age)
  //person.greet("daniel")
  person.greet()

  println("More Constructors....")
  println("here with name : "+new Person("name"))
  println("here without parameters : "+new Person())
}

//class Person and constructor on the same time
class Person(name: String, val age: Int) { // name and age is paramenters not class members means you can not call or access it by person.name or age
  // to do so we need to write val in front of paramenter variable so the it can become class member.
  val x = 2
  println(1 + 3)

  // function overloading
  def greet(name: String): Unit = println(s"${this.name} says : Hi, $name")

  def greet(): Unit = println(s"hi name is ${name}")

  // multiple constructors
  def this(name: String) = this(name, 0)

  def this() = this("temp name")

}