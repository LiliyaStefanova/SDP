import scala.annotation.tailrec

/**
 * Created by liliya on 30/03/2015.
 */
object Revision2 extends App {
  
  //Implement merge sort
  //split a list in 2
  //recursively call the algorithm on the sublist
  //merge it back together
  //takes two sorted lists and glues them together
  //will need a comparator function
  //returns a single list
  
  //doing it as a closure, i.e. partial function application - give you a high order function which returns 2 arguments
  //regular recursive solution 
  def merge[T](aList:List[T], bList:List[T])(cmp:(T, T)=>Boolean):List[T] = {
    
    (aList, bList) match {  //use a pair to match
      case(Nil, _) => bList
      case(_, Nil) => aList
      case(x :: xs, y :: ys) => 
        if(cmp(x, y)) x:: merge(xs, bList)(cmp)
        else y :: merge(aList, ys)(cmp)
      
    } 
    
  }
  
  //Appending a single item to a list is expensive, it has been tacked on the wrong way -need to reverse
  //tail recursive solution
  def mergeTail[T](aList:List[T], bList:List[T])(cmp:(T, T)=>Boolean):List[T] = {

    @tailrec
    def mergeHelper(aList:List[T], bList:List[T], accList:List[T]):List[T]={
      (aList, bList) match {
        case(Nil, _) => accList ++ bList
        case(_, Nil) => accList ++ aList
          case(x::xs, y::ys)=>
          if(cmp(x, y)) mergeHelper(xs,bList, accList :+ x)   //this is more expensive than ::
          else mergeHelper(aList, ys, accList :+ y)
        
      }
      
    }
    mergeHelper(aList, bList, Nil)
  }
  
    
  
  val l1 = List(1, 4, 5, 7)
  val l2 = List(2, 3, 5, 7, 12, 16)
  
  merge(l1, l2)((x, y)=> x <= y)  //<= if less than or equal to y, return true, else false - that's all the lambda does
  println(mergeTail(l1, l2)((x, y)=> x <= y))
}
