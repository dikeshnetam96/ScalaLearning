package QuestionSolutions

object TupleAndMapsExercise extends App {

  val people: List[(String, Int)] = List(("Alice", 25), ("Bob", 30), ("Charlie", 22), ("David", 35))

  val thresholdAge: Int = 30

  // Your code here

  // Expected result: List("Bob", "David")

/*  val filteredNames: List[String] = people.filter { case (_, age) => age > thresholdAge }.map { case (name, _) => name }

  println(filteredNames)*/

  val res = people.filter { case (_,age) => age > thresholdAge}.map{case (name,_) => name}
  println(res)
}
