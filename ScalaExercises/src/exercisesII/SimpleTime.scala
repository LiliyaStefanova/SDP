package exercisesII

/**
 * Created by liliya on 08/02/2015.
 */

case class SimpleTime(hours:Int, minutes:Int=0)

object SimpleTime{


  def main(args:Array[String]):Unit={
    val t = new SimpleTime(hours =5, minutes = 30)
    println(t.hours)

    val t1 = new SimpleTime(hours=10)
    println(t1.minutes)
  }

}


