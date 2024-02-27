package QuestionSolutions


abstract class Shape {
  def area(): Double
}

class Circle(radius: Double) extends Shape {
  override def area(): Double = Math.PI * radius * radius
}

class Rectangle(width: Double, hight: Double) extends Shape {
  override def area(): Double = width * hight
}
object AreaCalculate extends App {

  val circle = new Circle(5.0)
  val rectangle = new Rectangle(3.0, 4.0)

  println(s"Area of the circle: ${circle.area()}")
  // Output: Area of the circle: 78.53981633974483

  println(s"Area of the rectangle: ${rectangle.area()}")
  // Output: Area of the rectangle: 12.0

}
