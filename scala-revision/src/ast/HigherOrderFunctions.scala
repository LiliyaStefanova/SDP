package ast

/**
 * Created by liliya on 16/05/2015.
 */
object HigherOrderFunctions extends App {

  def testListMixed = List(-0.5, 0.0, 2.0, -3.2, 1.8, 10.9)
  val testList = List(3.0, 4.5, 2.1)
  val mixedList = List(List(1, 1), 2, List(3, List(5, 8)))

  //square all elements in a list - use map
  def squareElems(list:List[Double]):List[Double] = list map(x=>x*x)
  
  println("Functional squaring of list elements: " +squareElems(testList))
  
  //find all positive elements in a list - filter
  
  def posElems(list:List[Double]):List[Double] = list filter (x=> x>0)
  
  println("Functional way of returning a list containing only positive elements from another list: "+posElems(testListMixed))
  
  
  //find all negative elements in a list - filter 
  
  def negElems(list:List[Double]):List[Double] = list filter ( x => x<0)

  println("Functional way of returning a list containing only negative elements from another list: "+negElems(testListMixed))
  
  //2 versions of packing a list, i.e. taking it from individual repeating values to lists with same consecutive values combined
  
  def pack[T](xs:List[T]):List[List[T]] = xs match {
    case Nil => Nil
    case y::ys => pack(ys.dropWhile(z=>z == y)) :+ (y::ys.takeWhile(z=> z == y))
    
  }

  def pack1[T](xs:List[T]):List[List[T]] = xs match {
    case Nil => Nil
    case y::ys =>
      val (first, rest) = xs.span(z =>z == y)
      first :: pack(rest)

  }
  
  println("Packing a list: "+ pack1(List('a', 'a', 'a', 'b', 'c', 'c', 'c', 'a')))
  
  //Encoding the list to specify the symbol and how many times it occurs
  
  def encode[T](xs:List[T]):List[(T, Int)] = {

    pack(xs)  map (x=>(x.head, x.length))
    
  }
    
    println("Encoding a list: "+ encode(List('a', 'a', 'a', 'b', 'c', 'c', 'c', 'a')))

//folding

  def mapFun[T, U](xs: List[T], f: T => U): List[U] = (xs foldRight List[U]())(???)

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)(???)
  
  //reduce list
  
  
  //collect
  
  
  //fold
  
  
  //flatMap
 

  //partition 
  
  val parts: (List[Double], List[Double]) = testListMixed partition(x=> x>0)
  println("Partitioned Positives: "+parts._1)
  println("Partitioned Negatives: "+parts._2)


  //zip




 

}
