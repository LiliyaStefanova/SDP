package exercisesII.pattern_matching

/**
 * Created by liliya on 18/04/2015.
 */

  
object PatternMatchWeather extends App {

  def forecast(percent:Int):String = percent  match {
    case 100 => "Sunny"
    case 80 => "Mostly sunny"
    case 50 => "Partly Sunny"
    case 20 => "Mostly Cloudy"
    case 0 => "Cloudy"
    case _ => "Unknown"
  }

  println(forecast(100))
  println(forecast(80))
  println(forecast(20))
  println(forecast(0))
  
  val sunnyData = Vector(100, 80, 50, 20, 0, 15)
  sunnyData.foreach(x=>println(forecast(x)))
  

}

