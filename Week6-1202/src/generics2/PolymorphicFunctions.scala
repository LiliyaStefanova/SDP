package generics2

import java.awt.print.Book

import scala.annotation.tailrec


//T extends xxxx
//T extends   Notation - <:
//T super ?   Notation - >:
//Student extends Person
//Pair[Student] <=> Pair[Person]

// <% a view bound specifies implicit cast
/**
 * Created by liliya on 12/02/2015.
 */
object PolymorphicFunctions extends App {

  //Find the first element in a list that matches a criteria

  //Generics + tail recursion
  def findFirst[T](as:Array[T], value:T):Int={
    @tailrec
    def helper(n:Int):Int={
      if( n >= as.length) -1
      else if(value== as(n)) n
      else helper(n+1)
    }
    helper(1)
  }

  //Function is sorted to check if an array is sorted

  def isSorted[T <% Comparable[T]](at:Array[T], ord: (T, T)=>Boolean):Boolean = {
    def helper(n:Int):Boolean ={
      if(n == at.length-1)  true
      else if(ord(at(n), at(n+1))) false
      else helper(n+1)
    }
    helper(0)

  }

 // println(isSorted(Array(5, 7, 2, 0),  gt))
// does not work for generic types because it does not know how to compare
//  def gt[T](a: T, b:T):Boolean={
//    a > b
//  }

  isSorted(range, (a:Int, b:Int)=>a>b)
  println(findFirst(Array("a", "56", "67", "etc"), "67"))
  println(findFirst(Array("a", "56", "67", "etc"), "11"))
 // println(isSorted(Array(1, 6, 9, 11, 90, 12), gt))
  val range = Range(1, 10).toArray
  //println(isSorted(range, gt))



}
