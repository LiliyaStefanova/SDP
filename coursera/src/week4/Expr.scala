package week4

/**
 * Created by liliya on 21/05/2015.
 */
trait Expr {
  
  def isNumber:Boolean
  def isSum:Boolean
  def numValue:Int
  def leftOp:Expr
  def rightOp:Expr
  
  
}

class NumberExpr(n:Int) extends Expr {
  
  override def isNumber: Boolean = true

  override def rightOp: Expr = throw new Error("Right Op")

  override def numValue: Int = n

  override def isSum: Boolean = false

  override def leftOp: Expr = throw new Error("Left Op")
}

class SumExpr(left:Expr, right:Expr) extends Expr {
  
  override def isNumber: Boolean = false

  override def rightOp: Expr = right

  override def numValue: Int = throw new Error("Number")

  override def isSum: Boolean = true

  override def leftOp: Expr = left
  
  
}

object ExprTest extends App {


  def eval(e:Expr):Int = {
    if(e.isNumber) e.numValue
    else if(e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("Not a valid expression")

  }
  
  println(eval(new SumExpr(new NumberExpr(3), new NumberExpr(1))))
  
  
}
