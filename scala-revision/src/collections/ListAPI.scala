package collections

import scala.annotation.tailrec

/**
 * Created by liliya on 17/05/2015.
 */
object ListAPI extends App {
  
  //Test data 
  val mixedList = List(List(1, 1), 2, List(3, List(5, 8)))
  val nestedList = List(List(2, 4), List(1, 3))
  val intList = List(6, 2, 9, 1, 0)
  val intList2 = List(1, 3, 5, 7, 9)
  val doubleList = List(3.0, 4.5, 2.1)
  val doubleListMixed = List(-0.5, 0.0, 2.0, -3.2, 1.8, 10.9)
  val stringList = List("apple", "banana", "mango", "grapes")
 // val stringListNested(List("a", "b"), "c", List("d", "e"))

  /** Finding the last element of a list - use reverse **/
  def lastReverse[T](list:List[T]):T ={
    list.reverse(0)
  }
  //Test
  println("Finding the last element of a list using reverse: "+lastReverse(doubleListMixed))
  println("Finding the last element of a list using reverse: "+lastReverse(nestedList))


  /** Finding the last element of a list - using cons
    * * 
    */
  @tailrec
  def lastTraverse[T](list:List[T]): T = list match{
    case List(x) => x
    case y::ys => lastTraverse(ys)
  }
  
  println("Find the last element in a list by traversing: "+ lastTraverse(doubleListMixed))

  /**
   * Implementation of the built in reverse method in scala * 
   * Used the :+ method which appends value to a list 
   * :+ - append - list :+ element
   * +: prepend  - element +: list
   * Complexity: grows from 1 to xs - linear to the size of the list 
   * n for the concat + n for the reverse = n squared * *
   * the colon is always on the side of the collection!!!* * * * 
   * @param list to be reversed
   * @return new list with elements reversed
   */
  def reverseCustom[T](list:List[T]):List[T]= list match {
    case Nil=> Nil
    case y::ys => reverseCustom(ys):+y
      //or reverseCustom(ys) ++ List(y)
    
  }
  
  //testing
  println("Testing custom implementation of reversal for doubles: "+reverseCustom(doubleList))
  println("Testing custom implementation of reversal for strings: "+reverseCustom(stringList))

  def palindrome(word:String):Boolean = word.equalsIgnoreCase(word.reverse)

  println("Is madam a palindrome: "+palindrome("madam"))

  println("Square root of elements in reverse order: " +doubleListMixed.reverse.map(x=>Math.sqrt(x)))

  
  def filter[T](list:List[T])(p:T=>Boolean):List[T] = list match {
    case Nil => Nil
    case x::xs => if(p(x)) x::filter(xs)(p) else filter(xs)(p)
      
  }
  
  println("Filter negatives: "+ filter(doubleListMixed)(x=>x>0))
  /**
   * Concatenation here is of the same complexity I think, only it is built in a more complex way*
   * @param listA
   * @param listB
   * @tparam T
   * @return concatenated list
   */
  def concatenateCustom[T](listA:List[T], listB:List[T]):List[T] = (listA, listB) match {
    case (Nil, _) => listB
    case (_, Nil) => listA
    case (xs,ys)=> xs.head ::concatenateCustom(xs.tail, ys)
    
  }

  /**
   * Complexity for this implementation is |lisA| because we need to go though all listA elements* 
   * @param listA
   * @param listB
   * @tparam T
   * @return concatenated list
   */
  def concatenateComplexityLengthListA[T](listA:List[T], listB:List[T]):List[T] = listA match {
    case Nil => listB
    case x::xs => x::concatenateComplexityLengthListA(xs, listB)
    
  }
  println("Testing custom concatenation implement of two lists: "+concatenateCustom(intList, intList2))
  print("A more simple way to concatenate is just: ")
  println(intList++intList2)

  //span
  var tuple =  (List[Double](), List[Double]())
  tuple = doubleListMixed.span(x=>x>0.0)
  println("Result of span operations is: "+ tuple)
  
  //drop
  print("Drop the last three items of a listL ")
  println(intList drop 3)
  
  //take 
  print("Take the first two items of a list only: ")
  println(intList take 2)

  /**
   * Selects all elements except the last*
   */
  println("This is what init does:"+intList.init)

  /**
   * Returns a copy of this list with one single replaced element * 
   */
  print("This is what updated does: ")
  println(intList updated(3, 7))

  /**Finds the index of the first occurence of some value in a list 
   * 
   */
  print("This is what indexOf does: ")
  println(intList indexOf 0)

  /**
   * Takes elements which do not match the filter* 
   */
  println(doubleListMixed.filterNot(x=>x>0))

  /**
   * Takes the longest prefix of elements which match a certain criteria*
   */
  println(stringList takeWhile (x=>x.contains("n")))
  println(stringList dropWhile (x=>x.contains("n")))

  
  /** Flatten a sequence which contains all sequences of int **/

  def flatten(xs: Seq[Seq[Int]]):Seq[Int] =  xs match {
    case Nil => Nil
    case List(x) => x
    case y::ys => y ++ flatten(ys)

  }
  //test of nested list
  println(s"Flattened version of $nestedList: "+flatten(nestedList))


  /**
   * In order to flatten a list of any element we need to have two cases:
   * 1. when the head of the list is just an element (y:Int)::ys -> just append and call recursively on the tail
   * 2. When the head of the list may be a list or a nested list -> call flatten on it recursively and concatenate with a
   * recursive call on flattenGeneral on the tail. It is important here to concatenate using ++ NOT append using :: * *
   * @param xs list being flattened
   * @return flattened list
   */
  def flattenGeneral(xs:List[Any]):List[Any] = xs match {
    case Nil => Nil
   // case (y:Int)::ys => y :: flattenGeneral(ys)
    case(y:AnyRef)::ys=> y:: flattenGeneral(ys)
    case (y:List[Any])::ys => flattenGeneral(y) ++ flattenGeneral(ys)
    case _ => throw new MatchError("Unrecognised")
  }

  //test flatten 
  println("Mixed list flattened: "+flattenGeneral(stringList))

  /** Scale a list by a factor recursively **/

  def scale(xs:List[Double], factor:Double):List[Double] = xs match {
    case Nil => xs
    case hd::tail => hd*factor::scale(tail, factor)

  }
  
  //Test
  println("Scaled list non-tail recursively: "+ scale(doubleList, 3))

  /** Scale a list by a factor tail-recursively* 
    * @param xs
    * @param factor
    * @return scaled list
    */
  def scaleTail(xs:List[Double], factor:Double):List[Double] = xs match{
    case Nil => xs
    case hd::tail => {
      @tailrec
      def scaleHelper(acc: List[Double], ys: List[Double]): List[Double] = ys match {
        case Nil => acc
        //prepend and then reverse used for better performance 
        case z :: zs => scaleHelper(z * factor::acc, zs)
      }
      scaleHelper(List[Double](), xs).reverse
    }

  }

  //Testing 
  println("Tail recursive list scaling:" + scaleTail(doubleList, 2.0))
  
  @tailrec
  def lastCustom[T](list:List[T]):T = list match {
    case Nil => throw new Exception("List empty")
    case List(x) => x
    case x::xs=> lastCustom(xs)
    
  }
  
  println("The last element of the list is: "+ lastCustom(doubleListMixed))
  
  def initCustom[T](list:List[T]):List[T] = list match {
    case Nil => list
    case List(x) => Nil
    case x::xs => x::initCustom(xs)
    
  }
  
  println("All elements of a list except for the last one" + initCustom(doubleListMixed))

  
  def removeAt[T](xs:List[T], n:Int):List[T]= xs match {

    case Nil => xs
    case List(x) => if (n==0) Nil else List(x)
    case hd::tail => if(n==0) tail else hd::removeAt(tail, n-1)
    
  }
  
  def removeAtWithOtherMethods[T](xs:List[T], n:Int):List[T] = (xs take n) ::: (xs drop n+1)
  
  println("List with element at position 2 removed: "+ removeAt(doubleList, 2))
  println("Alternative implementation of removal: "+ removeAtWithOtherMethods(doubleList, 2))
  
  def mergeSort[T](list:List[T])(implicit ord:Ordering[T]):List[T] =   {
    val n = list.length/2
    if (n==0) list
    else {
      def merge(xs:List[T], ys:List[T]):List[T] = (xs, ys) match {
        case (Nil, a)=> ys
        case (b, Nil) => xs
        case((a:T)::as, (b:T)::bs) => if(ord.lt(a, b)) a::merge(as, ys) else b::merge(xs, bs)
      }
      val (first, second) = list splitAt n
      merge(mergeSort(first), mergeSort(second))

    }
  
  }

  println("Merge Sort: " + mergeSort(List(5, 3, 7, -3, 9, 10 , 13)))
    
  println("Merge sort with fruits: "+ mergeSort(stringList))
}
