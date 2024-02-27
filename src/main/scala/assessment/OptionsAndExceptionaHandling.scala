package assessment

import part3_functionalProgrammingInScala.L34_Options.myFirstOption

import scala.util.{Failure, Success, Try}

object OptionsAndExceptionaHandling extends App{

/*  val myFirstOption : Option[Int] = Some(4)
  val noOption : Option[Int] = None

  println(noOption)

  def unsafeMethod(): String = null
  // val result = some(null) // WRONG
  def backupMethod(): String = "A valid result"
  val result = Option(unsafeMethod()).orElse(Option(backupMethod()))

  def unsafeMethod2(): Option[String] = None

  // val result = some(null) // WRONG
  def backupMethod2(): Option[String] = Some("A valid result")

  val result2 = unsafeMethod2().orElse(backupMethod2())
  println(result2)

  println(myFirstOption.map(_*3))
  println(myFirstOption.filter(_%2==0))

  */

  def unsafeMethod(): String = throw new RuntimeException("NO STRING FOR YOU BUSTER")
  def backupMethods(): String = "A valid Result"

  val result = Try(unsafeMethod()).orElse(Try(backupMethods()))
  println(result)
  result.foreach(println)

  def unsafeMethod2(): Try[String] = Failure( new RuntimeException("NO STRING FOR YOU BUSTER"))

  def backupMethods2(): Try[String] = Success("A valid Result")

  val result2 = unsafeMethod2() orElse backupMethods2()
  println(result2)
  result2.foreach(println)
}
