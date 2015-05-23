package week5

/**
 * Created by liliya on 04/05/2015.
 */
object ListUtils extends App {

  def removeAt[T](n: Int, xs: List[T]) = {
    if (n > xs.size - 1) xs
    else (xs take n) ::: (xs drop n + 1)
  }

  def flatten(xs: List[Any]): List[Any] = {
    xs match {
      case List() => List()
      case y :: ys =>
// ys => println(y)
//        flatten(ys)
        if (y.isInstanceOf[Int]) y:: flatten(ys)
        else if (y.isInstanceOf[String]) y::flatten(ys)
        else  {
          y match {
            case z :: zs => z :: xs; flatten(zs)
          }
          //                    y match {
          //                      case List=> flatten(y.asInstanceOf[List[Any]]) ::: flatten(ys)
          //                      case Int => y::flatten(ys)
          //                      case _ => throw new MatchError("The element could not be matched")
          //                    }

        }

    }
  }
    //  
    //  var list = List('a', 'b', 'c', 'd')
    //  var list1 = List(1, 2, 5, 6)
    //  var list2 = List()
    //  list = removeAt(1, list)
    //  list1 = removeAt(5, list1)
    //  list2 = removeAt(1, list2)
    //  println(list)
    //  println(list1)
    //  println(list2)

    var listFlat = List(List(1, 1), 2, List(3, List(5, 8)))
    var listFlatSimple = List(List(1, 2), 2, 3)
    var listFlatAlready = List(1, 2, 4, 5)
    listFlat = flatten(listFlat)
    listFlatSimple = flatten(listFlatSimple)
    var flattenedList = flatten(listFlatSimple)
    println(flattenedList)
    println(listFlat)
    println(listFlatSimple)

  }


