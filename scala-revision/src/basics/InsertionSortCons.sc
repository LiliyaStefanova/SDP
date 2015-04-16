def isort(xs:List[Int]):List[Int] = xs match{
  case List() => List()
  case y::ys => insert(y, isort(ys))
}

def insert(x:Int, xs:List[Int]):List[Int] = xs match {
  case List() => List(x)
  case y::ys => if(x<y) x::ys
                else insert(x, ys)
  
}

val testList = List(5, 2, 8, 9, 1)
val sortedList = isort(testList)
sortedList
