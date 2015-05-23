package May14HelpSession

import scala.annotation.tailrec

/**
 * Created by liliya on 14/05/2015.
 */
object Revision extends App {
  
  def factorial(n:Int):Int ={
    @tailrec
      def helper(n:Int, acc:Int):Int = {
        if (n <= 0) acc
        else helper(n - 1, n * acc)

      }
    helper(n, 1)
  }
  
  println(factorial(4))

}
