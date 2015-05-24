package ast.coursera_example


/**
 * An adapted example from the Scala Coursera Pattern Matching lecture
 * Includes implementation of show method including appropriate formatting with "(" 
 */
trait Expr {
  
  def eval:Int = this match {

    case Num(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
  }

}

case class Num(n:Int) extends Expr

case class Sum(e1:Expr, e2:Expr) extends Expr

case class Prod(e1:Expr, e2:Expr) extends Expr

case class Var(name:String) extends Expr

object ExprTest extends App {

  def eval(e: Expr): Int = e match {

    case Num(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)

  }

  def show(e: Expr): String = e match {

    case Num(n) => n.toString
    case Sum(e1, e2) => show(e1) + "+" + show(e2) //brackets?
    case Var(x) => x
    case Prod(e1, e2) => (e1, e2) match {
      case (Sum(a, b), Sum(c, d)) => "(" + show(a) + " + " + show(b) + ")" +
                                      " * " + "(" + show(c) + " + " + show(d) + ")"
      case(x, Sum(a, b)) => show(x) + " * " + "("+ show(a) + " + " + show(b) + ")"
      case(Sum(a, b), x) => "("+ show(a) + " +" + show(b) + ")" +  "*" + show(x)
      case(any, other) => show(any) + "*" + show(other)
    }


  }
  
 val show = Sum(Sum(Num(4), Num(3)), Sum(Num(7), Num(4)))
  
  val showProd = Prod(Prod(Num(2), Var("x")), Sum(Var("y"), Num(1)))
  val showSumProdSum  = Prod(Sum(Num(3), Var("z")), Sum(Num(5), Var("a")))
  val OtherExprProdSum = Prod(Var("a"), Sum(Num(1), Var("b")))
  val showSumProdProd = Prod(Sum(Num(3), Num(5)), Prod(Num(6), Var("a")))
  
  println(show(show))
  
  println(show(showProd))
  
  println(show(showSumProdSum))
  
  println(show(OtherExprProdSum))
  
  println(show(showSumProdProd))
  
}