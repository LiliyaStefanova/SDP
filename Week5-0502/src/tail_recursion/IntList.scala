package tail_recursion

import scala.annotation.tailrec

/**
 * Created by liliya on 05/02/2015.
 */
sealed trait IntList{
//  @tailrec    //import statements in scala are scoped so can be imported to a location
//  def sum(total:Int =0):Int={
//    this match{
//      case EndOfList => total   //return total at the end as we are not unwinding the function so the
//      case Pair(hd, tl) => tl.sum(hd+total)
//    }
//
//  }
//  @tailrec
//  def product( total:Int=1):Int={
//    this match{
//      case EndOfList => total
//      case Pair(hd, tl) =>tl.product(hd*total)
//    }
//  }
//  @tailrec
//  def length(total:Int=0):Int={
//    this match{
//      case EndOfList =>total
//      case Pair(hd, tl) => tl.length(1+total)
//    }
//  }
  //abstract over methods -it is called fold as it folds the function in
  def fold(end:Int, f: (Int, Int)=>Int):Int={
    this match{
      case EndOfList =>end
      case Pair(hd,tl) => f(hd, tl.fold(end, f))
    }
}

  def sum:Int =
  fold(0, (hd, tl)=>hd+tl)

  def length:Int =
  fold(0, (_, tl)=>1+tl)   //anonymous placeholder _

  def product =
  fold(1, (hd, tl)=>hd*tl)
  
  /*
  abstraction(0, lam) =>f(1, Pair(2, Pair..., E.abstraction(0, lam)
  Pair(2, Pair..., E.abstraction(0, lam) -> f(2, Pair(2, Pair..., E.abstraction(0,  lam)
  Pair(2, Pair...E.abstraction(0, lam) -> f(3, Pair(4, E.abstraction(0, lam)
  Pair(4, E).abstraction(0, lam) -> f(4, Pair(4, E).abstraction(0, lam)
  Pair(4, E).abstraction(0, lam) -> f(E.abstraction(0, lam))
  E.abstraction(0, lam) -> return end = 0
  
  //unwinding
  0 +
  4 +
  3 +
  2+
  1
  the function takes the head and adds it to the abstraction result 
  f(x, y) = x+y
   */


}



//Contains constructors, getters, setters, copy, hashcode, equals
final case class Pair(head:Int, tail:IntList) extends IntList{

}
//singleton as only one EndOfList
final case object EndOfList extends IntList


object Main extends App{

  def l = Pair(1, Pair(2, Pair(3, Pair(4, EndOfList))))

  println(l)
  println(l.sum)
  println(l.product)
  println(l.length)
  //double(l)
  //Name: Recursive Algebraic Data Type Pattern

  //summing using tail recursion

  //tail recursion means we don't have to have a point to come back to-i.e. for recursion to return

  //tail rec checks and determines if the code is tail recursive
  //Runtime vs
  //  def sum(list:IntList):Int={
  //    list match{
  //      case EndOfList => 0
  //      case Pair(hd, tl) => hd +sum(tl)
  //    }


  //abstract over methods

//  def double(list:IntList):IntList = {
//    this match{
//      case EndOfList => EndOfList
//      case Pair(hd, tl) => Pair(hd*2, double(tl))
//    }
//  }
}