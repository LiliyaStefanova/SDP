package collections

/**
 * Created by liliya on 22/05/2015.
 */
object VectorAPI extends App{
  
  val vector1 = Vector(3.0, 2.9, 1.9, 4.7)
  val vector2 = Vector(4.6, 8.9, 2.1)

  /**
   * Scalar product of two vectors defined in two different ways* 
   * Returns the sum of the products between all elements in a vector * 
   */
  
  def scalarProduct1(v1:Vector[Double], v2:Vector[Double]):Double = {
    
    ((v1 zip v2) map (x=> x._1* x._2)).sum
    
  }
  
  def scalarProduct2(v1:Vector[Double], v2:Vector[Double]):Double = {
    
    (v1 zip v2).map{case (x, y)=>x*y}.sum
    
  }
  
  println("Scalar product 1: "+scalarProduct1(vector1, vector2))
  
  println("Scalar product 2: "+ scalarProduct2(vector1, vector2))


  //Example of append and prepend methods of a Collection
  def collectionPrepend(x: Vector[Char], c: Char) = {

    println(x :+ c) //append : always on the side of the collection
    println(c +: x) //prepend : always on the side of the collection

  }

  println ( collectionPrepend(Vector('a', 'b', 'c'), 'f'))



}
