package exercisesII.constructors

import exercisesII.AtomicTest._
/**
 * Created by liliya on 19/04/2015.
 */
class Tea(name: String="Earl Grey", decaf: Boolean=false, sugar: Boolean=false, milk: Boolean=false, calories:Int=0) {

  def describe(): String = {
    var description = name
    if (decaf)  description += " decaf" else  description += ""
    if (sugar) description += " sugar"  else description +=  ""
    if (milk) description += " milk" else description += ""
    description
  }
  
  def caloriesCalc():Int = {
    var cals = calories
    if(milk)  cals = cals + 100
    if(sugar) cals = cals + 16
    cals
  }

}

object Tea extends App {
  
  val tea = new Tea
  tea.describe() is "Earl Grey"
  tea.caloriesCalc() is 0
  
  
  val lemonZinger = new Tea(decaf = true, name="Lemon Zinger")
  lemonZinger.describe() is "Lemon Zinger decaf"
  lemonZinger.caloriesCalc() is 0
  
  val sweetGreen = new Tea(name="Jasmine Green", sugar = true)
  sweetGreen.describe() is "Jasmine Green sugar"
  
  val teaLatte = new Tea(sugar = true, milk = true)
  teaLatte.describe() is "Earl Grey sugar milk"
  teaLatte.caloriesCalc() is 116
  
}
