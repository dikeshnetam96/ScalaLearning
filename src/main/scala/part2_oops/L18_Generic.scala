package part2_oops

abstract class MyList1[+A] {
  /*
      head = first element of the list
      tail = remainder of the list
      isEmpty = is this list empty
      add(int) = new list with this element added
      toString = a string representation of the list
   */

  def head: A // Keep the value

  def tail: MyList1[A] // last node

  def isEmpty1: Boolean // check it has value of not

  /*
  Specifically, B >: A means that B must be a supertype of A.
  In other words, B should be equal to A or a more general type than A.
   */
  def add[B >: A](element: B): MyList1[B] // add element in this current node and returning new node

  def printElements: String = "[ " + printElements + " ]"

}

// By this method we can create a empty node
object Empty1 extends MyList1[Nothing] {
  override def head: Nothing = throw new NoSuchElementException()

  override def tail: MyList1[Nothing] = throw new NoSuchElementException()

  override def isEmpty1: Boolean = true

  override def add[B >: Nothing](element: B): MyList1[B] = new Cons1(element, Empty1)

  override def printElements: String = ""
}

// Cons1 will help to create a new node and link to current node value
class Cons1[+A](h: A, t: MyList1[A]) extends MyList1[A] {
  override def head: A = h

  override def tail: MyList1[A] = t

  override def isEmpty1: Boolean = false

  override def add[B >: A](element: B): MyList1[B] = new Cons1(element, this)

  override def printElements: String =
    if (t.isEmpty1) "" + h
    else { ""+h+ " "+t.printElements}
}

object ListTest extends App {
  val listOfIntegers: MyList1[Int] = new Cons1(1, new Cons1(2, new Cons1(3, Empty1)))
  val listOfStrings: MyList1[String] = new Cons1("Hello", new Cons1("Scala", Empty1))

  println(listOfIntegers.printElements)
  println(listOfStrings.printElements)
}

/*
In Scala, variance is a feature that helps define the relationships between types when dealing with inheritance and subtyping.
It's a way to specify whether a generic type parameter should be allowed to vary in a specific direction (either covariant,
contravariant, or invariant) when dealing with subtypes.

Here's a brief explanation of the different types of variance:

Covariant (+): If you declare a type parameter as covariant, it means that you can substitute a more specific type for a less specific one.
For example, if B is a subtype of A, you can use C[B] in place of C[A]. This is denoted by adding a + before the type parameter, like class C[+A].

Contravariant (-): If you declare a type parameter as contravariant, it means that you can substitute a less specific type for a more specific one.
For example, if B is a subtype of A, you can use C[A] in place of C[B]. This is denoted by adding a - before the type parameter, like class C[-A].

Invariant (default): If you don't specify any variance annotation, the type parameter is invariant. In this case, you cannot substitute one type
for another, regardless of their subtyping relationship.

Variance is important because it helps ensure type safety in situations where you have generic classes or functions that deal with different
types and their relationships. By specifying the variance correctly, you can prevent type errors and make your code more flexible and reusable.

Here's why variance is required:

Safety: By indicating how type parameters should vary with respect to subtyping, you can catch potential type errors at compile-time.
This prevents runtime errors and enhances the safety of your code.

Flexibility: Variance allows you to create more flexible and reusable code. It lets you design classes and functions that work with a
wider range of types without compromising type safety.

Interoperability: Variance annotations help ensure that your code can interact with libraries and APIs that use subtyping relationships correctly.
It ensures that your code integrates smoothly with other parts of your application or external libraries.
 */