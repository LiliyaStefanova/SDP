//package week4
//
//
///**
// * Created by liliya on 04/05/2015.
// */
class InsertionSort{

  def isort(xs : List[Int]): List[Int] = {
    xs match {
      case List() => List()
      case y::ys => insert(y, isort(ys))
    }
  }

  def insert(x: Int, xs: List[Int]): List[Int] =
    xs match {
    case List() => List(x)
    case y :: ys => if (x > y) y::insert(x, ys) else x::xs

  }

}

object InsertionSort extends App {

  val is = new InsertionSort
  def list = List(3, 7, 9)
  val list1 = is.insert(11, list)
  println(list1)
  val list2 = is.insert(2, list)
  println(list2)
  val list3 = is.insert(8, list)
  println(list3)



}
