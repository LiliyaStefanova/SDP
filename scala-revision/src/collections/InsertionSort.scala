package collections

/**
 * Created by liliya on 16/05/2015.
 */
object InsertionSort extends App {
  
  def sort(xs:List[Int]):List[Int] = xs match {
    case Nil => xs
    case y::ys => isort(sort(ys), y)
    
  }
  
  def isort(xs:List[Int], x:Int): List[Int] = xs match {
    case List() => List(x)
    case y::ys => if(x<y) x::y::ys else y::isort(ys, x)
  }
  
  val list = List(5, 3, 2)
  
  println("Sorted list: "+ sort(list) )

}
