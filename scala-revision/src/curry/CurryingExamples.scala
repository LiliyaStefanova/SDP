package curry

/**
 * Created by liliya on 24/05/2015.
 */
object CurryingExamples extends App {
  
  //currying - turn a function with multiple parameters in a list into a function with multiple 
  //parameter lists 
  
  def line(a:Int, b:Int, x:Int):Int = a*x + b
  
  def curriedLine(a:Int)(b:Int)(c:Int):Int = line(a, b, c)
  
  def defaultLine(x:Int):Int = curriedLine(1)(0)(x)
  
  println(defaultLine(5)) //should return 5
  
  //partial application - freeze one value and work with multiple args
  
  //partial line is a function which takes two ints and returns an int
  def partialLine = (b:Int, x:Int) => line(2, b, x)
  
  partialLine(0, 1) //returns 2
  
  //apply 2 to the line function => get back a function which takes 2 ints and returns and int
  def partialLine2 = line(2,_:Int, _:Int)
  
  //apply the two ints to partialLine2
  partialLine2(3,4)
  
  def ff(x:Int)(y:Int) = x + y 
  def f(x:Int, y:Int) = x + y
  
  //this: 
  ff(3)(4)
  
  //is the same as this:
  f(3, 4)
  
  //is the same as this: 
  //only here the application of the second argument is delayed
  //and an interim function x is generated
  val x = ff(3)_
  x(4)

}
