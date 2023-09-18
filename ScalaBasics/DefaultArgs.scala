package ValuesVariableTypes

import scala.annotation.tailrec

object DefaultArgs extends App{

// In this function no need to give initial value of 'acc' by default it will be 1. (Default Argument)
  @tailrec
  def trfact(x:Int,acc:Int=1): Int = {
    if(x<=1) acc
    else trfact(x-1,x*acc)
  }

  println(trfact(5))

  // Here all the parameters values are default argument
  def saveImage(format:String="jpg",height : Int = 1080, width:Int=1020):Unit={
    println("saved successfully....")
  }

  // Here, In both function we are changing the value of default Parameters during calling function.
  saveImage("bmp",400,800)
  saveImage()
  saveImage(width = 600,height = 400,format = "png")


}
