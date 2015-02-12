package generics2

import scala.annotation.tailrec

/**
 * Created by liliya on 12/02/2015.
 */
object Revision extends App {

  def factorial(n: Int): Int={
    @tailrec
    def accumulate(n:Int, acc:Int):Int ={
      if(n <=0) acc //last call needs to return the accumulator as we are not passing it back down the stack
      else accumulate(n-1, n*acc)
    }
    accumulate(n, 1)
  }

  println(factorial(5))

  def abs(x:Int):Int ={
    if(x<0) -x else x
  }

  println(abs(5))

//  private def prettyAbsoluteMessage(x:Int)={
//    s"The absolute value of $x is:  ${abs(x)} "
//  }
//
//  println(prettyAbsoluteMessage(-1))
//
//  private def prettyFactorialMessage(x:Int)={
//    s"The factorial for value of $x is : ${factorial(x)}"
//  }
//
//  println(prettyFactorialMessage(10))


  //abstracting through higher order function
  def prettyMessage(msg:String, x:Int, f:Int=>Int):String = {
    s"$msg $x is ${f(x)}"
  }

  println(prettyMessage("The factorial for value", 10, factorial))
  println(prettyMessage("The absolute value for ", -1234, abs))
}
