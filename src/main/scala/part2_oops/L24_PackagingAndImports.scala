package part2_oops

import part2_oops.L11_OOBasics_Exercise.Writer
import part1_scalaBasics._ // we can import all the files using this.
import part1_scalaBasics.{L3_Expressions,L4_Functions => Prices}  // we can import multiple scala files in this way
// L4_Functions => Prices // This expression used to remove conflict when multiple same named classes were called.

/*
Example :

import java.util.Date
import java.sql.{Date => SqlDate}

*/


object L24_PackagingAndImports extends App{

  val writer = new Writer("Danial","RockTheJVM",2018)
  println(writer.toString)

  // Packages are in hierarchy
  // matching folder structure

/*

  Default Imports
  java.lang - string, object, Exception
  scala - Int, Nothing, Function
  Scala.Preddef - println, ???

 */

}
