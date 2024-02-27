package part3_functionalProgrammingInScala

import java.util.Random

object L34_Options extends App {

  /*
  Options were implemented to deal with unsafe API.
   */
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  // WORK WITH unsafe APIs
  def unsafeMethod(): String = null
  // val result = some(null) // WRONG

  val result = Option(unsafeMethod()) // Some or None
  println(result)

  // chained methods
  def backupMethod(): String = "A valid result"

  val chainedReuslt = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // Design Unsafe APIs
  def betterUnsafeMethod(): Option[String] = None

  def betterBackupMethod(): Option[String] = Some("A Valid reuslt")

  val betterchainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // function option
  println(myFirstOption.isEmpty)
  println("get method called here : " + myFirstOption.get) // UNSAEF - DO NOT USE THIS (if myFirstOption is having null then it will give null and it break whole code)

  //map,flatmap,filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(_ % 2 == 0))
  println(myFirstOption.filter(_ % 2 != 0))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for-comprehensions

  /*
  Exercise
   */

  val config: Map[String, String] = Map(
    "host" -> "129.0.1.3",
    "port" -> "2345"
  )

  class Connected {
    def connect = "Connected" // connect to some server
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connected] = if (random.nextBoolean()) Some(new Connected())
    else None
  }

  // Assignment -
  // try to establish a connection, if so- print the connect method

  /*
    Sample for the connecting (yus some modification required for it)
    val testObj = Connection(config("host"), config("port")) orElse None
    println("Output String : "+testObj)

    val host = config.get("host")*/


  val host = config.get("host")
  val port = config.get("port")
  /*
    if(h!=null)
      if(p!=null)
        return Connection.apply(h,p)
   */

  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))

  /*
  if(c!=null)
    return c.connect
  return null
   */
  val connectionStatus = connection.map(c => c.connect)
  // if(connectionstatus == null) println(None) else print(Some(connectionstatus.get))

  println("Connection Message : "+connectionStatus)
  connectionStatus.foreach(println)
  /*
Difference between below two methods are  : for each will print data only when the data is present otherwise it will not print.

  println("Connection Message : "+connectionStatus)
            or
  connectionStatus.foreach(println)
 */

  /*
    if(status!=null)
      println(status)
   */

  connectionStatus.foreach(println)

  //chained calls
  println("chained calls------- ")
  config.get("host").flatMap(host => config.get("port").flatMap(port => Connection(host, port)).map(connection => connection.connect)).foreach(println)

  // for-comprehensions

  println("for-comprehensions------- ")
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    con <- Connection(host, port)
  } yield {
    con.connect
  }
  println("below this : ")
  forConnectionStatus.foreach(println)
  //  println(forConnectionStatus)
}
