package part3_functionalProgrammingInScala

object L32_TuplesAndMaps extends App {

  // tuples : finite ordered "lists"
  val aTuple = new Tuple2(2, "Hello, Scala") // Tuple2[Int,String] = (Int,String)
  val aTuple1 = (2, "Hello, Scala")
  println(aTuple._1) // 2   _1 is first element and _2 is second element
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("hello, Scala",2)

  // Maps - keys -> Values
  val aMap: Map[String, Int] = Map()

  // withDefaultValue is here because if any key came which is not in the map it will return -1.
  val phoneBook = Map(("Jim", 555), "Danial" -> 789,("JIM",9000)).withDefaultValue(-1)

  // a->b is sugar for (a,b)
  println(phoneBook)

  // map ops
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim")) // It is case sensitive

  // checking default value is working or not
  println(s"Checking default value here : ${phoneBook("Test")}")

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phoneBook + newPairing
  println(newPhonebook)

  // Functionals on Maps
  // map, flatMap,filters

  println(phoneBook.map(pair=> pair._1.toLowerCase -> pair._2))

  // filterkeys
  println(phoneBook.view.filterKeys(x=>x.startsWith("J")).toMap)

  // mapValues
  println(phoneBook.view.mapValues(number=>number*10))

  // Conversions to other Collections
  println(phoneBook.toList)
  println(List(("Daniel",555)).toMap)

  val names = List("Bob","Angela","James","Mary","Daniel","Jim")
  println(names.groupBy(name => name.charAt(0)))
}
