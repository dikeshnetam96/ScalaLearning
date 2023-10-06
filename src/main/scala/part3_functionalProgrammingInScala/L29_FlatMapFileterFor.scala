package part3_functionalProgrammingInScala

object L29_FlatMapFileterFor extends App {

  val list = List(1, 2, 3, 4)
  println(list.head)
  println(list.tail)

  //map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // filter map
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // print all combination between two lists
  val numbers = List(1, 2, 3, 4)
  val char = List('a', 'b', 'c', 'd')
  val color = List("black", "white")

  val pairing: (Int, Int) => String = (x, y) => x + "" + y

  // Iterating
  // to print combination of number and char values permutation
  println(numbers.flatMap(n => char.map(c => " " + c + " " + n)))

  // to print combination of number, char and color
  println(numbers.flatMap(n => char.flatMap(c => color.map(color => n + "" + c + "-" + color))))

  /*
  by above 2 example we can see that, if we need 2 loop we can use one flatmap and a map
  if we need 3 loops we need 2 flatmap and 1 map.
   */

  // forEach
  list.foreach(println)

  // for-comprehension
  val forCombinations = for {
    n <- numbers
    c <- char
    colors <- color
  } yield "" + n + c + "-" + colors

  println(forCombinations)

  // for-comprehension with filter
  val forCombinationsWithFilter = for {
    n <- numbers if n % 2 == 0
    /*
    It will gonna write in background is :
    numbers.filter(_%2==0).flatmap(n=>chars.flatmap(c=>colors.map(color=>" "+c+n+"-"+color)))
     */
    c <- char
    colors <- color
  } yield "" + n + c + "-" + colors

  println(forCombinationsWithFilter)

  // Syntax Overload
  val newTest = list.map{
    x => x*2
  }
  println(newTest.foreach(println))

  /*
  Assignment :

  1. MyList support for comprehension ?
      map(f:A=>B) => MyList[B]
      filter(p: A=>Boolean) => MyList[A] // filter should receive a predicate
      flatmap(f: A=>MyList[B]) => MyList[B]

  2. A small collection of at most One Element - Maybe[+T]
      -Map, flatmap, filter
   */

  }


