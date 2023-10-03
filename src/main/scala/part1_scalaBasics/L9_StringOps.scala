package part1_scalaBasics

object L9_StringOps extends App{

  val str : String = "Hello"

  // It will return the character of index 2.
  println(str.charAt(2))

  // It will print string from index 2 to end of the string.
  println(str.substring(2))

  // it will print string from index 3 to end of the string.
  println(str.substring(2,str.length-1))

  // It will return string length.
  println(str.length)

  val temp = "hello"
  // It will compare 'str' to 'temp'
  println(str.compareTo(temp))

  // It will comcat the 'str' string with 'temp'
  println(str.concat(temp))

  // It will replace letter 'l' with 'p' of 'str' string
  println(str.replace('l','p'))

  // It will print the index of first 'o'
  println(str.indexOf("o"))

}
