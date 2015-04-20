package exercisesII.class_arguments

/**
 * Created by liliya on 18/04/2015.
 */
object VarArgsSquared  extends App{
  
  def squareThem(nums:Int*) = {
    
    //map to apply square function to each of the items in list
    //fold left to sum items in list starting from left
    //fold left must take 0 as first argument for the currying(would be 1 if it was product)
    nums.map(x=>x*x).foldLeft(0)((x, y)=>x+y)
  }

  println(squareThem(2))
  println(squareThem(2, 4))
  println(squareThem(1, 2, 4))

}

