package mock_exam

/**
 * Created by liliya on 19/05/2015.
 */


class MultiSetExample {
  
  type MultiSet = Int=>Int
  
  def emptyMultiSet: MultiSet = _ => 0
  
  def singleton(x:Int):MultiSet = y => if(y==x) 1 else 0
  
  def union(a: MultiSet, b:MultiSet):MultiSet = y=> a(y) + b(y)

 // def intersect(a:MultiSet, b:MultiSet):MultiSet = y => min(a(y), b(y))
  
//  def diff(a:MultiSet, b:MultiSet):MultiSet = y=> max(a(y) - b(y), 0)

}

object MultiSetExample extends App {
  
  def emptyMultiThingyBlah: Int => Int = (x: Int) => 0
  
  def singletonThingy(x: Int): Int => Int = (y: Int) => if (y == x) 1 else 0
  
  def singletonThingyTry2(x: Int): Int => Int = {
    def someOtherFunctionThatCloses(y: Int) = {
      if (y == x) 1 else 0
    }
    someOtherFunctionThatCloses
  }
  
  
  
  val aMultiSet: Int => Int = y => y match {
    case 0 => 2
    case 3 => 5
    case 2 => 1
    case _ => 0

  }
  
  

}



