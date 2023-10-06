package part3_functionalProgrammingInScala

import java.awt.print.Printable
import java.util
import scala.collection.View.Collect
import scala.util.Random

object L31_Sequences extends App {

  // sequences : Sequence is an iterable collection of class Iterable
  val aSequnce = Seq(1, 5, 2, 3, 4) // this sequence is actually list, apply factory method which create sub class of Sequence
  println(aSequnce)
  println(aSequnce.reverse)
  println(aSequnce(2))
  println(aSequnce ++ Seq(4, 5, 6)) // concading two list into one
  println(aSequnce.sorted.reverse)
  println(aSequnce.sorted)

  // Ranges -> which are same as sequences
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(println)
  (1 to 10).foreach(x => println("Hello"))

  // List
  /*
  A LinearSeq immutable linked list
    - head,tail, isEmpty methods are fast : O(1)
    - most operations are O(n): length, reverse
   */

  val aList = List(1, 2, 3)
  // prepanding
  val prepended = 42 :: aList
  println(prepended)

  // prepanding
  val prepended2 = 42 +: aList
  println(prepended2)

  // postponding

  val postpanding = aList :+ 43
  println(postpanding)

  // appending element in both the side
  val append = 0 +: aList :+ 44
  println(append)

  // creating a list with 5 time "apple" element in list.
  val apple5 = List.fill(5)("apple")
  println(apple5)

  println(aList.mkString("-|-"))

  // Arrays
  val numebrs = Array(1, 2, 3, 4)
  println(numebrs.mkString("-"))
  val treeElements = Array.ofDim[Int](3) // creating array with defined locations.
  treeElements.foreach(println)

  // Mutation
  numebrs(2) = 0 // syntax sugar for numbers.update(2,0)
  println(numebrs.mkString("-"))

  // arrays and seq  // This is implicit conversion
  val numberSeq: Seq[Int] = numebrs
  print(numberSeq)

  // ----------------------------------------------------------------------------------------------------------------
  // Vector

  /*
  constant time for read and write
  implemented in fixed branch trie
   */

  val vector: Vector[Int] = Vector(1, 2, 3)
  vector.foreach(println)
  println(vector)

  // ------------------------------------------------------------------------------------------------------------------

  // vector vs List
  // checking the average of vector and List to perform the same task

  val maxRun = 1000
  val maxCapacity = 1000000

  // getWriteTime function take the sequence and using for-comprehension function to perform updating operation and calculating the average from maxRun.
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRun
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRun
  }

  val numberList = (1 to maxCapacity).toList
  val numberVector = (1 to maxCapacity).toVector

  // Advantage : keeps references to tail
  // Disadvantage : updating an element in middle take a long time
  println(getWriteTime(numberList))

  // Advantage : depth of the tree is small
  // Disadvantage : it need to replace an entire 32-element chunk
  println(getWriteTime(numberVector))

}