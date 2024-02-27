package part2_oops

abstract class MyList {
  /*
       Need to create a linked list...
       head = first element of the list
       tail = remainder of the list
       isEmpty = is this list empty
       add(int) = new list with this element added
       toString = a string representation of the list
    */
  def head: Int

  def tail: MyList

  def isEmpty: Boolean

  def add(element: Int): MyList

  def printElements: String = "[ " + printElements + " ]"
}

// It Depict the end node or null
object Empty extends MyList {
  override def head: Int = throw new NoSuchElementException()

  override def tail: MyList = throw new NoSuchElementException()

  override def isEmpty: Boolean = true

  override def add(element: Int): MyList = new Cons(element, Empty)

  override def printElements: String = ""
}

// Cons will help to create a new node and link to current node value
class Cons(h: Int, t: MyList) extends MyList {
  override def head: Int = h

  override def tail: MyList = t

  override def isEmpty: Boolean = false

  // Here new node created and connect it with the current node's tail.
  override def add(element: Int): MyList = new Cons(element, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object L17_Excersices_01 extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.tail.tail.isEmpty)

  // polymorphic call
  println(list.printElements)
}