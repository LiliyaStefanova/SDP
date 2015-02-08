package exercisesII

/**
 * Created by liliya on 08/02/2015.
 */
class Item(name:String, price:Double) {

  def cost(grocery:Boolean=false, medication:Boolean=false, taxRate:Double=0.10): Double = if(grocery) price else price + taxRate*price

}

object Item{

  def main(args:Array[String]):Unit={

    val flour = new Item(name="flour", 4)
    println(flour.cost(grocery=true))

    val sunscreen = new Item(name="sunscreen", 3)
    println(sunscreen.cost())

    val tv = new Item(name="television", 500)
    println(tv.cost(taxRate = 0.06))
  }
}
