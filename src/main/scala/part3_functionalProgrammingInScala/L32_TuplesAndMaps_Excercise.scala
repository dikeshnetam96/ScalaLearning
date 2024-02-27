package part3_functionalProgrammingInScala

import scala.annotation.tailrec
import scala.collection.MapOps

object L32_TuplesAndMaps_Excercise extends App {

  /*
        What would happen if I had two original entries "Jim"-> 555 and "JIM" -> 900?
        Overly simplified social network based on maps
        Person = String
        - add a person to the networks
        - remove a person
        - friend(mutual)
        - unfriend

        - number of friends of a person
        - person with most friends
        - how many people have NO friends
        - if there is a social connection two people (direct or n not)
     */

  // add function adds new persons into the map.
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  /*
  friend function made connection between two persons.
   */
  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  // unfriend function erase the connection between two persons.
  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  /*
  remove function returns the person from the entire graph
   */
  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  /*
  nFriends function return the total number of friends one person is having.
   */
  def nFriends(network: Map[String, Set[String]], person: String): Int = {
    if (!network.contains(person)) 0
    else network(person).size
  }

  /*
  mostFriends function return the name of person who is having the most number of friends
   */
  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  /*
  nPeopleWithNoFriends function returns the total number of persons who doesn't have any friends.
   */
  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int = {
    network.view.filterKeys(k => network(k).isEmpty).size
    // we can also write
    // network.filter(pair => pair._2.isEmpty).size
    // network.count(pair => pair._2.size)._1
    // network.count(_._2.isEmpty)
  }

  /*
  This function tells- person 'a' and 'b' are connected or not.
   */
  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople + person, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    bfs(b, Set(), network(a) + a)
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)
  println("No of friends : " + nFriends(testNet, "Bob"))
  println("Most Friends : " + mostFriends(testNet))
  println("People not having any Friends : " + nPeopleWithNoFriends(testNet))
  println("social connection : " + socialConnection(testNet, "Mary", "Jim"))
  println("social connection : " + socialConnection(network, "Mary", "Bob"))

}
