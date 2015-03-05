import scala.annotation.tailrec

/**
 * Created by liliya on 26/02/2015.
 */
object Thing extends App {
  
  def meth(i:Int):Int = ???
  
  //formal parameters can be called by:
      // call-by-ref- reference - passes in the location of the parameters and then evaluates
     //call-by-value value - parameters evaluated first
    // call-by-name -delayed evaluation -does not evaluate until used-lazy evaluation
  
  //:used to specify method will be called by name
  //takes in a lambda expression
  def methName(eval: =>Boolean) = {
    println(eval)
    if(eval){
      println("ug")
      }
    else{
      println("foo")
      
    }
  } 
  //var count =1
  //methName({println("ddd");count==1})
  //count+=1
  //println(methName(1==1))
  
  var count=1
  //don't have to put the brackets around the body, but we can do
  xxx(count<=5)({
    println(s"value $count")
    count+=1
  })
  
  //Domains specific construct
  //Implementing your own loop
  //call by value evaluates the conditional every time
  @tailrec
  def xxx(conditional: => Boolean)(body: => Unit):Unit ={
    if(conditional){
      body
      xxx(conditional)(body)
      
    }
    
  }
  
 // def yyy(i:Int, j:Int):Int = i+j
  def yyy(i:Int)(j:Int):Int = i+j 
  
  //println(yyy(3,4))   //regular call
  println(yyy(3)(4))    //curried call
}
