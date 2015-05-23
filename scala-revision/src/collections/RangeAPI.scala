package collections

import traits_and_inheritance.Book

/**
 * Created by liliya on 22/05/2015.
 */
object RangeAPI extends App{
  
  val hello = "Hello World"
  
  
  //Prime number checker - forall and exists 
  
  def prime(n:Int):Boolean = 2 until n forall(d=>n%d!=0)
  
  println("Is number prime: "+prime(1345))
  println("Is number prime: "+ prime(11))
  
  //String can also use functional methods and higher order functions 
  
  println("Are there capital letters: " + hello exists (_.isUpper))
  
  //flatMap
  
  println("Flatmap me: "+ hello flatMap(c => "." + c))
  
  //Give all the pairs of numbers in given ranges 
  
  val rangeCombinations = (1 to 10) flatMap (x=> (5 to 15) map (y=> (x, y)))
  
  println("Combinations are: "+ rangeCombinations)

}
