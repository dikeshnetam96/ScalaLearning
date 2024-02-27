package assessment

object sampleUse extends App {

/*

  def inputTaker(num : Int*) : List[Int]  = {
    def helper(seq: Seq[Int],list: List[Int]) : List[Int] = {
      if(seq.isEmpty)
        list
      else{
        helper(seq.tail,list:+seq.head)
      }
    }
    helper(num,List())
  }

  val newList = inputTaker(1,2,3,4,5)
  println(newList.getClass)
  println(newList)


*/

  trait Expr
  case class Sum(e1 : Expr, e2 : Expr) extends Expr
  case class Number(e1 : Expr) extends Expr
  case class Prod(e1 : Expr, e2 : Expr) extends Expr

  def show(e : Expr) : String = e match {
    case Number(e)=> s"$e"
    case Sum(e1,e2)=> show(e1)+" + "+show(e2)
    case Prod(e1,e2) => {
      def mayBeShowParanthesis(exp : Expr) = exp match {
        case Prod(_, _) => show(exp)
        case Number(exp) => show(exp)
        case _ => " ( " + show(exp) + " ) "
      }
      mayBeShowParanthesis(e1) +" * "+mayBeShowParanthesis(e2)
    }
  }

}
