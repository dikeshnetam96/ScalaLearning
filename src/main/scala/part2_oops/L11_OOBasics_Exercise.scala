package part2_oops

object L11_OOBasics_Exercise extends App {

  /*
  Novel and a Writer

  Writer : first name, surname , year
         - method fullname

  Novel : name, year of release, author
        - authorage
        - isWrittenBy(author)
        - copy(new year of release) = new instance of Novel
   */
  /*

  Counter Class :
  - receives an int value
  - method current count
  - method to increment/decrement => new Counter
  - overload inc/dec to receive an amount

  */

  /*
  Here We have created a Writer class with parameterized constructor, which will take 3 values
   */
  class Writer(fname: String, lname: String, year: Int) {

    // This method will return author's complete name
    def fullName(): String = {
      return fname + " " + lname
    }
  }

  // Novel Class with parameterized constructor which takes 3 values
  class Novel(name: String, var yor: Int, author: Writer) {
    // this method will return year of book published
    def authorAge(): Int = yor

    // this method will return author name
    def isWrittenBy(nameOfAuthor: String): Boolean = nameOfAuthor == author.fullName()

    // This method will create a copy of with new publish year
    def copy(newYear: Int): Boolean = {
      yor = newYear
      true
    }

    // THis method will create a copy of current object.
    def copyObj(newYear: Int): Novel = {
      new Novel(name, newYear, author)
    }
  }

  class Count {
    var value = 0;

    def inputValue(temp: Int): Boolean = {
      value = temp;
      true
    }

    def currentCount(): Int = value

    def incrementVal(): Int = {
      value = value + 1;
      value
    }

    def decrementVal(): Int = {
      value = value - 1;
      value
    }

    def incrementVal(amount: Int): Int = {
      amount + 1
    }

    def decrementVal(amount: Int): Int = {
      amount - 1
    }
  }

  class Counter(val count: Int = 0) {
    def inc = {
      println("incrementing")
      new Counter(count + 1)
    }

    def dec: Counter = {
      println("decremention ")
      new Counter(count - 1)
    }

    def print() = println(count)
  }

  val writer = new Writer("Yann", "Martel", 1996)
  println(writer.fullName())

  val novel = new Novel("Life of Pi", 2001, writer)
  println(s"year of book released ${novel.yor}")
  println("name of author is same : " + novel.isWrittenBy("Yann Martel"))
  println("changing birth year of author : " + novel.copy(2002))
  println(novel.authorAge())
  val newObj = novel.copyObj(2002)
  println("new time is : " + newObj.yor + " and the new object is :" + newObj)
  println("---------------------------------------------------------------")

  val cnt = new Count
  println("inserting a new value " + cnt.inputValue(5))
  println("incrementing value : " + cnt.incrementVal())
  println("decrementing value : " + cnt.decrementVal())
  println("incrementing operation with input value : " + cnt.incrementVal(500))
  println("decrementing operation with input value : " + cnt.decrementVal(cnt.incrementVal(500)))

  println("---------------------------------------------------------------------")
  val counter = new Counter(6)
  println(counter.inc.inc.count)
  counter.inc.inc.print()


}