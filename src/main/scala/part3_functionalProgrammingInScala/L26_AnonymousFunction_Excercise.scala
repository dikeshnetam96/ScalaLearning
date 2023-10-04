package part3_functionalProgrammingInScala

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

  def printElements: String

  override def toString: String = "[ " + printElements + " ]"

  //higher order function

  def map[B](transform: A => B): MyList1[B]

  def flatMap[B](transform: A => MyList1[B]): MyList1[B]

  def filter(myPredicate: A => Boolean): MyList1[A]

  def ++[B >: A](list: MyList1[B]): MyList1[B]
}

// By this method we can create a empty node
object Empty1 extends MyList1[Nothing] {

  def head: Nothing = throw new NoSuchElementException

  def tail: MyList1[Nothing] = throw new NoSuchElementException

  override def isEmpty1: Boolean = true

  def add[B >: Nothing](element: B): MyList1[B] = new Cons1(element, this)

  override def printElements: String = ""

  //  def map[B](transform: MyTransform[Nothing, B]): MyList1[B] = Empty1
  def map[B](transform: Nothing => B): MyList1[B] = Empty1

  //    def flatMap[B](transform: MyTransform[Nothing, MyList2[B]]): MyList2[B] = Empty2

  //  def filter(predicate: MyPredicate[Nothing]): MyList1[Nothing] = Empty1

  def ++[B >: Nothing](list: MyList1[B]): MyList1[B] = list

  /* def flatMap[B](transformer: MyTransform[A, MyList2[B]]): MyList2[B] =
     transformer.converAToB(h) ++ t.flatMap(transformer)*/

  override def flatMap[B](transform: Nothing => MyList1[B]): MyList1[B] = Empty1

  override def filter(myPredicate: Nothing => Boolean): MyList1[Nothing] = Empty1
}

// Cons1 will help to create a new node and link to current node value
class Cons1[+A](h: A, t: MyList1[A]) extends MyList1[A] {
  override def head: A = h

  def tail: MyList1[A] = t

  override def isEmpty1: Boolean = false

  override def add[B >: A](element: B): MyList1[B] = new Cons1(element, this)

  override def printElements: String = if (t.isEmpty1) h.toString else h + " " + t.printElements

  //h + " " + t.printElements
  /*
  [1,2,3].filter(n%1==0) =
  [2,3].filter(n%2==0) =
  = new Cons2(2, [3].filter(n%2==0))
  = new Cons2(2, Empty2.filter(n%2==0))
  = new Cons2(2. Empty2)
   */
  override def filter(predicate: A => Boolean): MyList1[A] = if (predicate(h)) new Cons1(h, t.filter(predicate))
  else t.filter(predicate)

  /*
  [1,2,3].map(n * 2)
    = new Cons2(2, [2,3].map(n * 2))
    = new Cons2(2, new Cons2(4,[3].map(n*2))
    = new Cons2(2, new Cons2(4, new Cons2(6,Empty2.map(n))))
   */
  override def map[B](transform: A => B): MyList1[B] = new Cons1(transform(h), t.map(transform))

  /*
  [1,2] ++ [3,4,5]
  = new Cons2(1, [2] ++ [3,4,5])
  = new Cons2(1, new Cons2(2, Empty2 ++ [3,4,5]))
  = new Cons2(1, new Cons2(2, new Cons2(3, new Cons2(4, new Cons2(5, Empty2)))))
  */
  def ++[B >: A](list: MyList1[B]): MyList1[B] = new Cons1(h, t ++ list)

  def flatMap[B](transformer: A => MyList1[B]): MyList1[B] = transformer(h) ++ t.flatMap(transformer)

}

trait MyPredicate[-T] {
  def test(t: T): Boolean
}

trait MyTransform[-A, B] {
  def converAToB(a: A): B
}

object L27_AnonymousFunction_Excercise extends App {
  val listOfIntegers: MyList1[Int] = new Cons1(1, new Cons1(2, new Cons1(3, Empty1)))
  val cloneListOfInteger: MyList1[Int] = new Cons1(1, new Cons1(2, new Cons1(3, Empty1)))
  val anotherListOfIntegers: MyList1[Int] = new Cons1(4, new Cons1(5, Empty1))
  val listOfStrings: MyList1[String] = new Cons1("Hello", new Cons1("Scala", Empty1))

  println(listOfIntegers.printElements)
  println(listOfStrings.printElements)

  println(listOfIntegers.map(new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }).toString)

  println("New Expression with Anonymous/Lambda Expression : " + listOfIntegers.map(ele => ele * 2).toString)
  println("New Expression with underscore : " + listOfIntegers.map(_ * 2).toString)

  println(listOfIntegers.filter(new Function[Int, Boolean] {
    override def apply(v1: Int): Boolean = v1 % 2 == 0
  }).toString)

  println("New Expression with Anonymous,Lambda Expression : " + listOfIntegers.filter(ele => ele % 2 == 0).toString)
  println("New Expression with underscore : " + listOfIntegers.filter(_ % 2 == 0).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)

  println(listOfIntegers.flatMap(new Function[Int, MyList1[Int]] {
    override def apply(v1: Int): MyList1[Int] = new Cons1[Int](v1, new Cons1[Int](v1 + 1, Empty1))
  }).toString)

  println("New Expression with Anonymous,Lambda Expression : " + listOfIntegers.flatMap(ele => new Cons1(ele, new Cons1(ele + 1, Empty1))).toString)
  // here we can't use '_' because it used it twice or multiple times in statement
  println("New Expression with Underscore : " + listOfIntegers.flatMap(ele => new Cons1(ele, new Cons1(ele + 1, Empty1))).toString)

  println(cloneListOfInteger == listOfIntegers)


}

