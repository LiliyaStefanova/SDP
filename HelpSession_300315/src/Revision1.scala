/**
 * Created by liliya on 30/03/2015.
   Given a list -flatten out so all items are on top level
   can't use flatten
   if not list or integer, throw a match error*
 */
object Revision1 extends App {
  

  
  val regularList = List(List(1, 4, 6), List(3, 7, 8), List(8, 9, 1), 6)
  
  def flattenList(list:List[Any]):List[Int]={
      
    list match {
      case Nil => Nil
      case(x:Int)::xs => x :: flattenList(xs) //prepend head x to the rest of the tail
      // ::: generalized to sequences
     //not tail recursive because it has something to do when it comes back, i.e. pre-pend 
      case(x:List[Any]) :: xs => flattenList(x) ++ flattenList(xs) //prepend the flatten list recursive call to the remainder
      case _ => throw  new MatchError()
      
    }
    
  }
  
  def flattenTail(list:List[Any]):List[Int]= {

    def flattenHelper(x: List[Any], acc: List[Int]): List[Int] = {
      x match {
        case Nil => acc //return accumulator when we run out of list
        case (x: Int) :: xs => x :: flattenHelper(xs, acc)
        case (x: List[Any]) :: xs => flattenHelper(x, flattenHelper(xs, acc))
        case _ => throw new MatchError()

      }
    }
    flattenHelper(l2, Nil)
  }
  
  var l=List()
  println(flattenList(l))
  var l1 = List(1, 2, 3)
  //println(flattenList(l1)) 
  var l2 = List(1, 2, List(3, 4, 5), List(4, 5, 67), List(), 778)
  //println(flattenList(l2))
 // var l3 = List("a", "b", "c")
  println(flattenList(l2))
  println(flattenTail(l2))


  def length(l: List[Any]): Int ={
    def helper(xs:List[Any], count: Int): Int ={
      case Nil => count
      case (y:Any)::ys => helper(ys, count + 1)
      case _ => "unknown"
    }
    helper(l, 0)
  }

  val list = List(1, 3, 5, 7)
  println("List Length" + length(list))

}
