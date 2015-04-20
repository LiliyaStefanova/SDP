package exercisesII.map_and_reduce

import exercisesII.AtomicTest._

object Reduce extends App {

  val v = Vector(1, 10, 100, 1000)
  //using reduce
  v.reduce((sum, n) => sum + n) is 1111

  //re-written with a for loop
  def sumWithFor(v:Vector[Int]) = {
    val v1 = Vector[Int]()
    var sum:Int = 0
    for(i<-v) {
      sum = sum + i
    }

    sum
    
  }
  
  sumWithFor(v) is 1111
  
  def sumIt(varargs:Int*):Int ={
    varargs.reduce((sum, n) =>sum + n)
  }
  
  sumIt(1, 2, 3) is 6
  sumIt(45, 45, 45, 60) is 195
  
}
