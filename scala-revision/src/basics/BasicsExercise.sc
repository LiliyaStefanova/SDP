import scala.annotation.tailrec

/* Tail recursive factorial */

def factorial(n:Int): Int ={
  @tailrec
  def helper(n:Int, acc:Int):Int={
    if(n==0) acc
    else helper(n-1, n*acc)
  }
    helper(n, 1)
      
}
factorial(4)

//def length(l: List[Any]): Int ={
//  def helper(xs:List[Any], count: Int): Int ={
//    case Nil => count
//    case (y:Any)::ys => helper(ys, count + 1)
//    case _ => "unknown"
//  }
//  helper(l, 0)
//}
//
//val list = List(1, 3, 5, 7)
//println(length(list))


def squareList(xs:List[Int]):List[Int] = {xs match{
  case List() => List()
  case y::ys => y*y :: squareList(ys) 
}}

def squareListMap(xs:List[Int]):List[Int] = xs map {x:Int => x*x}

val testList = List(2, 3, 4, 5)

println(squareList(testList))
println(squareListMap(testList))