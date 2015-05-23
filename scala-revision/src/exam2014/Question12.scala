package exam2014

/**
 * Created by liliya on 23/05/2015.
 */
object Question12 extends App{
  
  val list1 = List(1, 2, 4)
  val list2 = List(2, 5)
  val vector1 = Vector(2, 3, 4, 15, 17, 20)
  val vector2 = Vector("mango", "kiwi", "berry", "banana", "pineapple")
  val vector3 = Vector("banana", "pineapple", "mango", "kiwi", "berry")

  def squareArgs(xs:List[Int]):Int = ((xs map (x=>x*x)) fold 0)(_+_)
  
  def oddGT10(xs:Vector[Int]):Vector[Int] = {
      
    (for(i <- 0 to xs.length-1 if xs(i) % 2 != 0 && xs(i) >10)  yield xs(i)).toVector
    
  }
  //Sorting by increasing length 
  val sortedAscLen = vector2.sortWith(_.length<_.length)
  //sorting by decreasing length 
  val sortedDescLength = vector2.sortWith(_.length>_.length)
  //sorting by alphabetical order
  val sortedAlphaOrder = vector2.sorted
  //sorting by values containing e first
  val sortedContainingE = vector3.sortBy(x=>x.contains("e")).reverse
  
  val squaredArgs = squareArgs(list1)
  val oddAndOver10 = oddGT10(vector1)
  
  println("Asending order: "+sortedAscLen)
  println("Descending order: "+ sortedDescLength)
  println("Alpha order: "+ sortedAlphaOrder)
  println("Containing e first: " + sortedContainingE)
  
  println("Squared arguments: "+ squaredArgs)
  println("Odd and over 10: "+ oddAndOver10)

}
