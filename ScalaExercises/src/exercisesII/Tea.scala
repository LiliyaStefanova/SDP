package exercisesII

/**
 * Created by liliya on 08/02/2015.
 */
class Tea(name:String="Earl Grey", milk:Boolean=false, sugar:Boolean=false, decaf:Boolean=false) {

  def describe: String = {

    name + " + " + (if (milk) "milk") + " + "+ (if(sugar) "sugar") + " + " + (if(decaf) "decaf")
  }

  def calories:Int = {
    var calories = 0
    if(milk) calories = calories+100
    if(sugar) calories= calories+16

    calories
  }

}

object Tea{

  def main(args:Array[String]):Unit={

    val tea = new Tea
    println(tea.describe)
    println(tea.calories)

    val lemonZinger = new Tea(decaf=true, name="Lemon Zinger")
    println(lemonZinger.describe)
    println(lemonZinger.calories)

    val sweetGreen = new Tea( name="Jasmine Green", sugar=true)
    println(sweetGreen.describe)
    println(sweetGreen.calories)


    val teaLatte = new Tea(sugar=true, milk=true)
    println(teaLatte.describe)
    println(teaLatte.calories)
  }
}
