package sample_paper

/**
 * Created by liliya on 10/05/2015.
 */
object LSort extends App {

  //Implementation 1 
  def lsort(list: List[List[Symbol]]): List[List[Symbol]] = {
    var sortedList = List[List[Symbol]]()
    list.foreach(y => sortedList = isort(y, sortedList))
    sortedList

  }

  def isort(y: List[Symbol], ys: List[List[Symbol]]): List[List[Symbol]] = ys match {

    case List() => y :: ys
    case z :: zs => if (y.length < z.length) y :: z :: zs
    else z :: isort(y, zs)
  }

  //Implementation 2
  def lsort1(list: List[List[Symbol]]): List[List[Symbol]] = {
    list.sortBy(x=>x.length)

  }

  def lsortFreq(list: List[List[Symbol]]): List[List[Symbol]] = {
    var freqMap = Map[List[Symbol], Int]() withDefaultValue 0
    list.foreach(y => freqMap = freqMap + (y -> (freqMap(y) + 1)))
    val l = freqMap.toList.sortBy(_._2)
    l map (x=> x._1)
  }
  
  //Testing

  val list = List(List('a, 'b, 'c), List('d, 'e),
                  List('f, 'g, 'h), List('d, 'e),
                  List('i, 'j, 'k, 'l), List('m, 'n), 
                  List('o))
  
  val freqList = List(List('i, 'j, 'k, 'l), List('o),
                      List('a, 'b, 'c), List('f, 'g, 'h), List('f, 'g, 'h),
                      List('d, 'e), List('d, 'e),
                      List('m, 'n))
  
  println(lsort1(list))
  println(lsortFreq(freqList))

  //This can't be right - tuples length cannot be determined at runtime like a list's
 // lsortFreq((('a, 'b, 'c), ('d, 'e), ('f, 'g, 'h), ('d, 'e),
 // ('i, 'j, 'k, 'l), ('m, 'n), ('o)))
}
