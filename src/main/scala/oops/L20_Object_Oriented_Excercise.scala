package oops
import math.Fractional.Implicits.infixFractionalOps
import math.Integral.Implicits.infixIntegralOps

abstract class MyList2[+A] {
  /*
      head = first element of the list
      tail = remainder of the list
      isEmpty = is this list empty
      add(int) = new list with this element added
      toString = a string representation of the list
   */

  /*
  Assignment Description :

  1. Generic trait MyPredicate[-T] with a little method test(T) => Boolean
  2. Generic trait MyTransformer[-A,B] (contains method to convert type A to type B) with a method transform(A) => B
  3. MyList -
      -map(transformer) => MyList
      -filter(predicate) = > MyList
      -flatMap(transformer from A to MyLIst[B]) => MyList[B]

      class EvenPredicate extends MyPredicate[Int]
      class StringToIntTransformer extends MyTransformer[String, Int]

      [1,2,3].map(n*2) = [2,4,6]
      [1,2,3,4].filter(n%$2) = [2,4]
      [1,2,3].flatMap(n => [n,n+1]) => [1,2,2,3,3,4]
   */


  def head: A

  def tail: MyList2[A]

  def isEmpty2: Boolean

  def add[B >: A](element: B): MyList2[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  /*
  Specifically, B >: A means that B must be a supertype of A.
  In other words, B should be equal to A or a more general type than A.
   */
  //    def add[B>:A] (element : B) : MyList2[B]

  def map[B](transform: MyTransform[A, B]): MyList2[B]

  def flatMap[B] (transform: MyTransform[A,MyList2[B]]) : MyList2[B]
  def filter(predicate: MyPredicate[A]): MyList2[A]
  // concatenation
  def ++[B>:A] (list : MyList2[B]) : MyList2[B]

}

object Empty2 extends MyList2[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList2[Nothing] = throw new NoSuchElementException

  override def isEmpty2: Boolean = true

  def add[B >: Nothing](element: B): MyList2[B] = new Cons2(element, this)

  override def printElements: String = ""

  def map[B](transform: MyTransform[Nothing, B]): MyList2[B] = Empty2

  //    def flatMap[B](transform: MyTransform[Nothing, MyList2[B]]): MyList2[B] = Empty2

  def filter(predicate: MyPredicate[Nothing]): MyList2[Nothing] = Empty2
  def ++[B>:Nothing] (list : MyList2[B]): MyList2[B] = list

 /* def flatMap[B](transformer: MyTransform[A, MyList2[B]]): MyList2[B] =
    transformer.converAToB(h) ++ t.flatMap(transformer)*/

  override def flatMap[B](transform: MyTransform[Nothing, MyList2[B]]): MyList2[B] = Empty2
}

class Cons2[+A](h: A, t: MyList2[A]) extends MyList2[A] {
  override def head: A = h
  def tail: MyList2[A] = t
  override def isEmpty2: Boolean = false
  override def add[B >: A](element: B): MyList2[B] = new Cons2(element, this)
  override def printElements: String = if (t.isEmpty2) "" + h else ""+ h + " " + printElements
  //h + " " + t.printElements
  /*
  [1,2,3].filter(n%1==0) =
  [2,3].filter(n%2==0) =
  = new Cons2(2, [3].filter(n%2==0))
  = new Cons2(2, Empty2.filter(n%2==0))
  = new Cons2(2. Empty2)
   */
  override def filter(predicate: MyPredicate[A]): MyList2[A] = if (predicate.test(h)) new Cons2(h, t.filter(predicate))
  else t.filter(predicate)
  /*
  [1,2,3].map(n * 2)
    = new Cons2(2, [2,3].map(n * 2))
    = new Cons2(2, new Cons2(4,[3].map(n*2))
    = new Cons2(2, new Cons2(4, new Cons2(6,Empty2.map(n))))
   */
  override def map[B](transform: MyTransform[A, B]): MyList2[B] = new Cons2(transform.converAToB(h), t.map(transform))
/*
  [1,2] ++ [3,4,5]
  = new Cons2(1, [2] ++ [3,4,5])
  = new Cons2(1, new Cons2(2, Empty2 ++ [3,4,5]))
  = new Cons2(1, new Cons2(2, new Cons2(3, new Cons2(4, new Cons2(5, Empty2)))))
 */
  def ++[B>:A] (list : MyList2[B]) : MyList2[B] = new Cons2(h,t ++ list)

  def flatMap[B] (transformer : MyTransform[A,MyList2[B]]) : MyList2[B] =
    transformer.converAToB(h) ++ t.flatMap(transformer)
}

trait MyPredicate[-T] {
  def test(t: T): Boolean
}

trait MyTransform[-A, B] {
  def converAToB(a: A): B
}

object L20_Object_Oriented_Excercise extends App {
  val listOfIntegers: MyList2[Int] = new Cons2(1, new Cons2(2, new Cons2(3, Empty2)))
  val listOfIntegers2: MyList2[Int] = new Cons2(4, new Cons2(5,Empty2))
  val listOfStrings: MyList2[String] = new Cons2("Hello", new Cons2("Scala", Empty2))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
  println(listOfIntegers.map(new MyTransform[Int, Int] {
    override def converAToB(a: Int): Int = a * 2
  }).toString)

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(t: Int): Boolean = t % 2 == 0
  }).toString)

  println((listOfIntegers ++ listOfIntegers2 ))
  println(listOfIntegers.flatMap(new MyTransform[Int,MyList2[Int]] {
    override def converAToB(a: Int): MyList2[Int] = new Cons2(a , new Cons2(a+1,Empty2))
  }).toString)
}

/*
In Scala, variance is a feature that helps define the relationships between types when dealing with inheritance and subtyping. It's a way to specify whether a generic type parameter should be allowed to vary in a specific direction (either covariant, contravariant, or invariant) when dealing with subtypes.

Here's a brief explanation of the different types of variance:

Covariant (+): If you declare a type parameter as covariant, it means that you can substitute a more specific type for a less specific one. For example, if B is a subtype of A, you can use C[B] in place of C[A]. This is denoted by adding a + before the type parameter, like class C[+A].

Contravariant (-): If you declare a type parameter as contravariant, it means that you can substitute a less specific type for a more specific one. For example, if B is a subtype of A, you can use C[A] in place of C[B]. This is denoted by adding a - before the type parameter, like class C[-A].

Invariant (default): If you don't specify any variance annotation, the type parameter is invariant. In this case, you cannot substitute one type for another, regardless of their subtyping relationship.

Variance is important because it helps ensure type safety in situations where you have generic classes or functions that deal with different types and their relationships. By specifying the variance correctly, you can prevent type errors and make your code more flexible and reusable.

Here's why variance is required:

Safety: By indicating how type parameters should vary with respect to subtyping, you can catch potential type errors at compile-time. This prevents runtime errors and enhances the safety of your code.

Flexibility: Variance allows you to create more flexible and reusable code. It lets you design classes and functions that work with a wider range of types without compromising type safety.

Interoperability: Variance annotations help ensure that your code can interact with libraries and APIs that use subtyping relationships correctly. It ensures that your code integrates smoothly with other parts of your application or external libraries.
 */
