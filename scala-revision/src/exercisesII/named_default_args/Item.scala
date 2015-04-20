package exercisesII.named_default_args

/**
 * Created by liliya on 19/04/2015.
 */
class Item(name:String, price:Double) {
  
  def cost(grocery:Boolean=false, medication:Boolean = false, taxRate:Double = 0.10) = {
    if(grocery) price 
    else price + price * taxRate

  }
  
}

object Item extends App{
  val flour = new Item(name="flour", 4)
  println(flour.cost(grocery=true))
  val sunscreen = new Item(
    name="sunscreen", 3)
  println(sunscreen.cost())
  val tv = new Item(name="television", 500)
  println(tv.cost(taxRate = 0.06))
  
}

