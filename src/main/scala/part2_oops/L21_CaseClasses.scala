package part2_oops

object L21_CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim.toString) // or we can write as println(jim)
  println(jim)

  // 3. Equals and hashCode implemented Out Of The Box
  val jim2 = new Person("Jim", 34)

  // for 'case class' it will be true but if it would be normal 'class' it will return false.
  println(jim == jim2)

  // 4. Case Classes have handy copy method
  val jim3 = jim.copy(age = 45) // it also receive named parameter
  println(jim3)

  // 5. Case Classes companion objects
  val thePerson = Person // it has some factory methods
  val mary = Person("Mary", 23)
  println(thePerson)
  println(mary)

  // 6. Case Classes are serializable
  // Akka used it. Generally during network packet sending

  //7. Case Classes extractor patterns = Case Classes can be used in PATTERN MATCHING

  case object unitedKingdom {
    def name: String = "string from unitedkingdom class"
    // case objects has same properties as case classes except they don't get companion object because they are their companion object.
  }

  /*

  Learning form this lecture :

  Quick LightWeight data structure with little boilerplate

  sensible equals, hashcode, toString

  auto-promoted params to fields

  cloning
  
  case objects
   */

}
