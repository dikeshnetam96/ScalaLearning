package QuestionSolutions

import QuestionSolutions.BinaryTreeCreation.preOrderTraversal

import scala.io.StdIn.readLine

object BinaryTreeCreation extends App {

  case class Node(val data: Int, var left: Node, var right: Node)

  def createNodes(): Node = Node(readLine().toInt, null, null)

  def mainRunnableFunction: Node = {
    val num: Int = readLine().toInt
    if (num == -1)
      Node(-1, null, null)
    else
      Node(num, mainRunnableFunction, mainRunnableFunction)
  }


  // pre-order -->
/*  def preOrderTraversal(val node : Node) : Unit  = {
    if(node.data == -1){""}
    else {
      print(node.data+ " ")
      preOrderTraversal(node.left)
      preOrderTraversal(node.right)
    }
  }*/

  def preOrderTraversal(node : Node) : Unit ={
    if(node.data.equals(-1)) print("")
    else{
      print(node.data+" ")
      preOrderTraversal(node.left)
      preOrderTraversal(node.right)
    }
  }

  def inOrderTraversal(node: Node): Unit = {
    if (node.data.equals(-1)) print("")
    else {
      preOrderTraversal(node.left)
      print(node.data + " ")
      preOrderTraversal(node.right)
    }
  }

  def postOrderTraversal(node: Node): Unit = {
    if (node.data.equals(-1)) print("")
    else {
      preOrderTraversal(node.left)
      preOrderTraversal(node.right)
      print(node.data + " ")
    }
  }

  val binaryTree: Node = mainRunnableFunction
  println("printing PreOrder Traversal :")
  preOrderTraversal(binaryTree)
  println(" ")
  println("printing InOrder Traversal :")
  inOrderTraversal(binaryTree)
  println(" ")
  println("printing PostOrder Traversal : ")
  postOrderTraversal(binaryTree)
}
