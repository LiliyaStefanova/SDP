package exercisesII.named_default_args

/**
 * Created by liliya on 18/04/2015.
 */
//named arguments
case class SimpleTime(hours:Int, minutes:Int) {}

//default arguments
case class SimpleTime2(hours:Int, minutes:Int = 0)

object SimpleTime extends App{
  val t = new SimpleTime(hours = 5, minutes = 30)
  val t1 = new SimpleTime2(hours = 10)
  println(t.hours)
  println(t1.hours)
  println(t.minutes)
  println(t1.minutes)

}

 
  

