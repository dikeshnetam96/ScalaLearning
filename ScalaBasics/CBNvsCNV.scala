package ValuesVariableTypes

object CBNvsCNV extends App {

  // call by value compute value in the beginning at the level of parameter section
  def calledByValue(x:Long):Unit = { // // here it compute nano.time() once and then use it till end of function execution
    println("the value : "+ x)
    println("the value : "+ x)
  }

  // call by name will compute value when it is needed
  def calledByName(x: => Long) : Unit ={
    println("by Name : "+x) // here it compute nano.time()
    println("by Name : "+x) // here it compute nano.time()
  }

  //Called By Value
  calledByValue(System.nanoTime())

  // Called By Name
  calledByName(System.nanoTime())

  def infinite(): Int = 1+infinite()
  def printFirst(x:Int,y: => Int):Unit = println(x)

  printFirst(34, infinite())//printFirst(infinite(),34) will cause problem
}
