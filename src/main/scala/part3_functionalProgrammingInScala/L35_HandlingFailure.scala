package part3_functionalProgrammingInScala

import scala.util.{Failure, Random, Success, Try}

object L35_HandlingFailure extends App {

  // create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("NO STRING FOR YOU BUSTER")

  // here try caught the Exception and wrapped it up with Failure. Try Object via the apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)
  println("----------------------------------------------")
  // syntax sugar
  val anotherPotentialFailure = Try {
    // code that might throw
  }

  // utilities
  println(potentialFailure.isSuccess) // default method

  // orElse
  def backupMethods(): String = "A valid Result"

  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethods()))
  fallbackTry.foreach(println)
  println(fallbackTry)

  // If you design the API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)

  def betterBackupMethod(): Try[String] = Success("A valid result")

  val betterFallBack = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterFallBack)

  /*
  Exercise
   */

  val hostName = "localhost"
  val port = "8080"

  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random((System.nanoTime()))
      if (random.nextBoolean()) "<html>....</html>"
      else throw new RuntimeException("Connection Interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection =
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  // if you get the html page from the connection, print it to the console i.e. call renderHTML
  //  val con = Try(Connection.)

  /*
  Don't know whats the problem :
  val page  = Try(HttpService.getConnection(hostName, port).get("google.com")).map(page => renderHTML(page))
  */

  /*
  udemy solution
  - just need to add some safe methods which will surround methods into a Try block.
   */

  val possibleConnection = HttpService.getSafeConnection(hostName, port)
  val possibleHTML = possibleConnection.flatMap(con => con.getSafe("/home"))
  possibleHTML.foreach(renderHTML)

  //shorten version
  HttpService.getSafeConnection(hostName, port).flatMap(con => con.getSafe("/home")).foreach(renderHTML)

  //for-comprehension version
  for {
    con <- HttpService.getSafeConnection(hostName, port)
    page <- con.getSafe("/home")
  } yield renderHTML(page)

  // imperative language logic
  /*

  try{
  connection = HttpService.getSafeConnection(hostName, port)
  try{
    page = connection.get("/home")
    rederHTML(page)
  } catch(Some Other Exception)
  } catch(Some Exception)

   */
}
