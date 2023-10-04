package part3_functionalProgrammingInScala

abstract class MyList2[+A] {
  /*
      head = first element of the list
      tail = remainder of the list
      isEmpty = is this list empty
      add(int) = new list with this element added
      toString = a string representation of the list
   */

  /*
  Exercises :

  [1,2,3].forEach(x => println(x))

  - sortFunction((A,A)=>Int) => MyList
    [1,2,3].sort((x,y)=>y-x) => [3,2,1]

  - zipWith (list, (A,A)=>B)=> MyList[B]
    [1,2,3].zipWith([4,5,6],x*y) => [1*4,2*5,3*6]

  - fold(start)(function) => a Value
    [1,2,3].fold(0)(x+y) = 6

   2. toCurry(f:(Int,Int)=>Int) => (Int => Int => Int)
      fromCurry(f: (Int => Int => Int)) => (Int,Int) => Int

   3. compose(f,g) => x => f(g(x))
      andThen(f,g) => x => g(f(x))

   */

  def head: A // Keep the value

  def tail: MyList2[A] // last node

  def isEmpty2: Boolean // check it has value of not

  /*
  Specifically, B >: A means that B must be a supertype of A.
  In other words, B should be equal to A or a more general type than A.
   */
  def add[B >: A](element: B): MyList2[B] // add element in this current node and returning new node

  def printElements: String

  override def toString: String = "[ " + printElements + " ]"

  //higher order function

  def map[B](transform: A => B): MyList2[B]

  def flatMap[B](transform: A => MyList2[B]): MyList2[B]

  def filter(myPredicate: A => Boolean): MyList2[A]

  def ++[B >: A](list: MyList2[B]): MyList2[B]

  def foreach(f: A => Unit): Unit

  def sort(compare: (A, A) => Int): MyList2[A]

  def zipWith[B, C](list: MyList2[B], zip: (A, B) => C): MyList2[C]

  def fold[B](start: B)(operator: (B, A) => B): B
}

// By this method we can create a empty node
object Empty2 extends MyList2[Nothing] {

  def head: Nothing = throw new NoSuchElementException

  def tail: MyList2[Nothing] = throw new NoSuchElementException

  override def isEmpty2: Boolean = true

  def add[B >: Nothing](element: B): MyList2[B] = new Cons2(element, this)

  override def printElements: String = ""

  //  def map[B](transform: MyTransform1[Nothing, B]): MyList2[B] = Empty2
  def map[B](transform: Nothing => B): MyList2[B] = Empty2

  //    def flatMap[B](transform: MyTransform1[Nothing, MyList2[B]]): MyList2[B] = Empty2

  //  def filter(predicate: MyPredicate[Nothing]): MyList2[Nothing] = Empty2

  def ++[B >: Nothing](list: MyList2[B]): MyList2[B] = list

  /* def flatMap[B](transformer: MyTransform1[A, MyList2[B]]): MyList2[B] =
     transformer.converAToB(h) ++ t.flatMap(transformer)*/

  override def flatMap[B](transform: Nothing => MyList2[B]): MyList2[B] = Empty2

  override def filter(myPredicate: Nothing => Boolean): MyList2[Nothing] = Empty2

  // hofs
  override def foreach(f: Nothing => Unit): Unit = ()

  def sort(compare: (Nothing, Nothing) => Int) = Empty2

  def zipWith[B, C](list: MyList2[B], zip: (Nothing, B) => C): MyList2[C] =
    if (!list.isEmpty2) throw new RuntimeException("List do not have same length")
    else Empty2

  def fold[B](start: B)(operator: (B, Nothing) => B): B = start


}

// Cons2 will help to create a new node and link to current node value
class Cons2[+A](h: A, t: MyList2[A]) extends MyList2[A] {
  override def head: A = h

  def tail: MyList2[A] = t

  override def isEmpty2: Boolean = false

  override def add[B >: A](element: B): MyList2[B] = new Cons2(element, this)

  override def printElements: String = if (t.isEmpty2) h.toString else h + " " + t.printElements

  //h + " " + t.printElements
  /*
  [1,2,3].filter(n%1==0) =
  [2,3].filter(n%2==0) =
  = new Cons2(2, [3].filter(n%2==0))
  = new Cons2(2, Empty2.filter(n%2==0))
  = new Cons2(2. Empty2)
   */
  override def filter(predicate: A => Boolean): MyList2[A] = if (predicate(h)) new Cons2(h, t.filter(predicate))
  else t.filter(predicate)

  /*
  [1,2,3].map(n * 2)
    = new Cons2(2, [2,3].map(n * 2))
    = new Cons2(2, new Cons2(4,[3].map(n*2))
    = new Cons2(2, new Cons2(4, new Cons2(6,Empty2.map(n))))
   */
  override def map[B](transform: A => B): MyList2[B] = new Cons2(transform(h), t.map(transform))

  /*
  [1,2] ++ [3,4,5]
  = new Cons2(1, [2] ++ [3,4,5])
  = new Cons2(1, new Cons2(2, Empty2 ++ [3,4,5]))
  = new Cons2(1, new Cons2(2, new Cons2(3, new Cons2(4, new Cons2(5, Empty2)))))
  */
  def ++[B >: A](list: MyList2[B]): MyList2[B] = new Cons2(h, t ++ list)

  def flatMap[B](transformer: A => MyList2[B]): MyList2[B] = transformer(h) ++ t.flatMap(transformer)

  // hofs
  /*def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }*/

  /* def foreach(f: A => Unit): Unit = {
     f(h)
     t.foreach(f)

   }*/

  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A, A) => Int): MyList2[A] = {
    def insert(x: A, sortedList: MyList2[A]): MyList2[A] = {
      if (sortedList.isEmpty2) new Cons2(x, Empty2)
      else if (compare(x, sortedList.head) <= 0) new Cons2(x, sortedList)
      else new Cons2(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B, C](list: MyList2[B], zip: (A, B) => C): MyList2[C] =
    if (list.isEmpty2) throw new RuntimeException("Lists do not have same length")
    else new Cons2(zip(h, list.head), t.zipWith(list.tail, zip))

  def fold[B](start: B)(operator: (B, A) => B): B = t.fold(operator(start, h))(operator)
}

trait MyPrdedicate[-T] {
  def test(t: T): Boolean
}

trait MyTransform1[-A, B] {
  def converAToB(a: A): B
}

abstract class Maybe[+T] {

  def map[B](f: T => B): Maybe[B] // inputs a function

  def flatMap[B](f: T => Maybe[B]): Maybe[B] // inputs a function

  def filter(p: T => Boolean): Maybe[T] // inputs a predicate

}

case object MaybeNot extends Maybe[Nothing] {

  // MaybeNot is an Empty Collection...
  def map[B](f: Nothing => B): Maybe[B] = MaybeNot

  def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot

  def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot


}

case class Just[+T](value: T) extends Maybe[T] {

  def map[B](f: T => B): Maybe[B] = Just(f(value))

  def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)

  def filter(p: T => Boolean): Maybe[T] =
    if (p(value)) this
    else MaybeNot

}

/*object MaybeTest extends App {


}*/

object L27_HOFsCurries_Exercise extends App {

  val listOfIntegers: MyList2[Int] = new Cons2(1, new Cons2(2, new Cons2(3, Empty2)))
  val cloneListOfInteger: MyList2[Int] = new Cons2(1, new Cons2(2, new Cons2(3, Empty2)))
  val anotherListOfIntegers: MyList2[Int] = new Cons2(4, new Cons2(5, Empty2))
  val listOfStrings: MyList2[String] = new Cons2("Hello", new Cons2("Scala", Empty2))

  println(listOfIntegers.printElements)
  println(listOfStrings.printElements)

  //  println("New Expression with Anonymous/Lambda Expression : " + listOfIntegers.map(ele => ele * 2).toString)
  println("New Expression with underscore : " + listOfIntegers.map(_ * 2).toString)


  //  println("New Expression with Anonymous,Lambda Expression : " + listOfIntegers.filter(ele => ele % 2 == 0).toString)
  println("New Expression with underscore : " + listOfIntegers.filter(_ % 2 == 0).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)

  println("New Expression with Underscore : " + listOfIntegers.flatMap(ele => new Cons2(ele, new Cons2(ele + 1, Empty2))).toString)

  println(cloneListOfInteger == listOfIntegers)

  // for each
  listOfIntegers.foreach(println)

  // sorting
  println(listOfIntegers.sort((x, y) => x - y))

  // ZipWith
  println(anotherListOfIntegers.zipWith[String, String](listOfStrings, _ + " - " + _))

  //folding
  println(listOfIntegers.fold(0)(_ + _))

  /*
  Assignment 2 and 3 are implemented below :
  2. toCurry.
  3. Composed method.
   */
  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) = x => y => f(x, y)

  def fromCurry(f: (Int => Int => Int)): ((Int, Int) => Int) = (x, y) => f(x)(y)

  def compose[A, B, T](f: A => B, g: T => A): T => B = x => f(g(x))

  def andThen[A, B, C](f: A => B, g: B => C): A => C = x => g(f(x))

  def superAdder2: (Int => Int => Int) = toCurry(_ + _)

  def add4 = superAdder2(4)

  println(add4(17))

  // Higher Order Functions
  val superAdder = (x: Int) => (y: Int) => x + y

  val sampleAdder = fromCurry(superAdder)
  println(sampleAdder(4, 17))

  val add2 = (x: Int) => x + 2
  val times = (x: Int) => x * 3
  val composed = compose(add2, times)
  val ordered = andThen(add2, times)

  println("composed : " + composed(4))
  println("ordered : " + ordered(4))

  // for comprehensions
  val forComprehensions = for {
    n <- listOfIntegers
    string <- listOfStrings
  } yield "" + n + "-" + string

  println(forComprehensions)


  val just3 = Just(3)
  println(just3)
  println(just3.map(_ * 2))
  println(just3.flatMap(x => Just(x % 2 == 0)))
  println(just3.filter(_ % 2 == 0))
}
