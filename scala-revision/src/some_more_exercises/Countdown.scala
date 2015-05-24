package some_more_exercises

import scala.annotation.tailrec

/**
 * Created by liliya on 24/05/2015.
 */
object Countdown extends App{
  
  def evenCountdown2(n:Int):Unit = (for(i<- 0 to n if i%2 == 0) yield i).reverse map(x=>println(x))

  @tailrec
  def evenCountdown3(n:Int):Unit = n match {
    case 0 => println(n)
    case x => if(x%2==0) {
                 println(x)
                 evenCountdown3(x-1)
              }
              else evenCountdown3(x-1)
  }
  
  evenCountdown2(20)
  
  println()
  
  evenCountdown3(20)
}
