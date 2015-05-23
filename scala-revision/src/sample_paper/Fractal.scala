package sample_paper

/**
 * Created by liliya on 17/05/2015.
 */
object Fractal extends App {
  
  val BASE = List[String]("/|", " |")
  
  //line up the fractals and return them
  def fractal(n:Int):List[String] = {
    helper(n).reverse
      
  }
  //generate fractals
  def helper(n:Int):List[String] = {
    if (n == 1) BASE
    else ((helper(n - 1) zip helper(n-1)) map (x=>x._1+ x._2)) ++ ((helper(n-1) map (x=> spaces(n-1)+x)) map(y=>spaces(n-1)+y))
  }
  
  //generate some spaces
  def spaces(n:Int):String = if (n==1) " " else  spaces(n-1)+spaces(n-1)

  
  //print result
  println(fractal(5) mkString("\n"))
  
}
