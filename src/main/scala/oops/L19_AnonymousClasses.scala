package oops

object L19_AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // This is the code perform the below AnonymousClasses$$anon$1 class functionality behind the scene process...
  /*
    val funnyAnimal : Animal = new Animal {
      override def eat: Unit = println("testing text for anonymous class")
    }
  */

  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("testing text for anonymous class")
  }

  val funnyAnimal: Animal = new AnonymousClasses$$anon$1
  println(funnyAnimal.getClass)

  // Creating a Class named Person with name parameterized constructor
  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name , how can I help?")
  }

  // Redefining the SayHi function with new statement.
  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how tcan I be of serivce?")
  }
  /*
  Behind the scene, what is happening is :
  class AnonymousClasses$$anon$1 extendsPerson("Jim") {
      override def sayHi: Unit = println(s"Hi, my name is Jim, how tcan I be of serivce?")
    }
   */
}
