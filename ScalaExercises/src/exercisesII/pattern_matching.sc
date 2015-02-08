//Pattern matching

def forecast(percentage:Int) ={
  percentage match{

    case 100 => "Sunny"
    case 80 => "Mostly sunny"
    case 50 => "Partly Sunny"
    case 20 => "Mostly Sunny"
    case 0 =>  "Cloudy"
    case _ => "Unknown"

  }
}

forecast(100)
forecast(80)
forecast(50)
forecast(20)
forecast(0)
forecast(15)

val sunnyData = Vector(100, 80, 50, 20, 0, 15)

for(p:Int <- sunnyData) {
  println(forecast(p))
}