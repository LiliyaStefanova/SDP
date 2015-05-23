package collections

/**
 * Created by liliya on 16/05/2015.
 */
object ListReduction {



  //Using fold and reduce to define sum and product of list

  def sum(ls: List[Int]): Int = ls.foldLeft(0)(_+_)

  def product(ls: List[Int]): Int = ls.foldLeft(1)(_*_)

  //sum and product in terms of reduce

  def sumReduce(ls: List[Int]): Int = ls.reduceLeft (_+_)

  def productReduce(ls: List[Int]): Int = ls reduceLeft (_*_)


  //Defining sum and product of lists recursively 
  
  def sumRecursive(ls:List[Int]): Int = ls match  {
    case Nil => 0
    case hd::tail => hd + sumRecursive(tail)
    
  }
  
  def prodRecursive(ls:List[Int]): Int = ls match {
    case Nil => 1
    case hd::tail => hd * prodRecursive(tail)
  }

  def sum2(xs:List[Double]):Double = (0.0::xs) reduceLeft (_ + _)
  def product2(xs:List[Double]):Double = (1.0::xs) reduceLeft (_ * _)

  def sum3(xs:List[Double]):Double = (xs foldLeft 0.0) (_ + _)
  def product3(xs:List[Double]):Double = (xs foldLeft 1.0) (_ * _)


  val list = List(1, 4, 5, 7, 9)

  val x:List[Double] = List(3.4,1.2,-5.23,-6.23,2.0,4.5)



  println("Sum of items in a list with fold: "+ sum(list))
  println("Product of items in a list with fold: "+ product(list))
  
  println("Sum of items in a list with reduce: "+  sumReduce(list))
  println("Product of items in a list with reduce: "+ productReduce(list))
  
  println("Sum of items recursively: "+sumRecursive(list))
  println("Product of items recursively: "+prodRecursive(list))

}
