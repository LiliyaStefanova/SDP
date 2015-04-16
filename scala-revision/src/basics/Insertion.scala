package basics

/**
 * Created by liliya on 15/04/2015.
 */
object Insertion extends App{


  def isort(xs:List[Int]):List[Int] = xs match{
    case List() => List()
    case y::ys => insert(y, isort(ys))
  }

  def insert(x:Int, xs:List[Int]):List[Int] = xs match {
    case List() => List(x)
    case y::ys => if(x<y) x::xs
    else y::insert(x, ys)

  }

  val testList = List(5, 2, 8, 9, 1)
  val sortedList = isort(testList)
  sortedList.foreach(x=>println(x))
}
