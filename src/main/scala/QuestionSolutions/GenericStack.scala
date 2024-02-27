package QuestionSolutions


class Stack[A] {
  private var elements: List[A] = List.empty

  // Method to push an element onto the stack
  def push(item: A): Unit = {
    elements = item :: elements
  }

  // Method to pop an element from the stack
  def pop(): Option[A] = {
    elements match {
      case head :: tail =>
        elements = tail
        Some(head)
      case Nil =>
        None
    }
  }

  // Method to check if the stack is empty
  def isEmpty: Boolean = elements.isEmpty
}
object GenericStack extends App {

  // Test the generic stack
  val stringStack = new Stack[String]
  stringStack.push("First")
  stringStack.push("Second")
  stringStack.push("Third")

  while (!stringStack.isEmpty) {
    println(stringStack.pop().getOrElse("Stack is empty"))
  }
  /*
  val intStack = new Stack[Int]
  intStack.push(1)
  intStack.push(2)
  intStack.push(3)

  while (!intStack.isEmpty) {
    println(intStack.pop().getOrElse("Stack is empty"))
  }
  */
}
