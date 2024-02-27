package part2_oops

object L15_InheritanceAndTraits extends App {

  // Objects which contains unimplemented or abstract fields and methods call abstract classes they are defined by Abstract KeyWord.

  // Abstract Class
  abstract class Animal{
    val creatureType : String
    def eat : Unit
  }

  class Dog extends Animal{
    override val creatureType: String = "canine"
    override def eat: Unit = println("Overrided function")
  }

  // traits : Ultimated abstract datatype in scala (it can)
  // trait can have abstract and non abstract methods and attributes

  trait Carnivore{
    def eat(animal: Animal) : Unit
    def preferredMeal : String = "Fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    override def eat : Unit = println("Hii")
    override def eat(animal: Animal) : Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // traits do not have constructor parameters  // trait Carnivor(name:String) --> This is wrong
  // Multiple traits may be inherited by the same class
  // traits  = behavior, abstract class = thing
}