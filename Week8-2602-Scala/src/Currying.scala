/**
 * Created by liliya on 26/02/2015.
 */
object Currying extends App{
        
      //Partial application of arguments
      def cat1(s1: String)(s2:String) = s1+s2
  
    //takes a string and return a function which takes a String and returns the 
      def cat2(s1:String)=(s2:String) =>s1+s2
  
      println(cat1("hello")(" world"))
      println(cat2("hello")(" world"))
  
  val f = cat2("Boris")
  val s = f(" the spider")
  println(s)
  
  //returns the function that takes an int and add 2 items together
  def addn(n:Int)= (i:Int) =>i+n
  
  val add5= addn(5)
  
  println(add5(10))
  println(add5(13))
  
  val add7= addn(7)
  println(add7(10))
  println(add7(13))
}
