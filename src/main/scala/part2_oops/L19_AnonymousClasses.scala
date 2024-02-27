package part2_oops

object L19_AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // This is the code perform the below AnonymousClasses$$anon$1 class functionality behind the scene process...
  /*
    val funnyAnimal : Animal = new Animal {
      override def eat: Unit = println("testing text for anonymous class")
    }

    An anonymous class in Scala is a class that is defined without a name,
    typically for the purpose of creating a single instance of that class inline.
    Anonymous classes are often used to provide concrete implementations for traits or
    abstract classes directly at the point of instantiation, without the need to define
    a separate named class. They are created using the new keyword followed by the declaration
    of the trait or abstract class, along with the implementation of any abstract methods.
    Anonymous classes are concise and are particularly useful when a temporary and one-off implementation is needed.
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
