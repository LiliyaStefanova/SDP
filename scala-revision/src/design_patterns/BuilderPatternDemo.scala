package design_patterns

/**
 * Builder pattern is also a creation pattern
 * It is used to build complex objects using simple object and a
 * step by step approach. The builder is independent of other objects
 * In this example:
 * 1. Create a sealed trait Item and Packing - interface representing food item and packing
 * 2. Create Burger and Drinks which extend Item and Wrapper and Bottle which extend Packing - concrete classes to implement traits
 * 3. Create different types of burgers and drinks to make up items - specific classes for specific functionality
 * 3. Create a meal class which is made up of Items (contains a list of Item) - class composed of multiple Item objects
 * 4. Create a MealBuilder, which creates the different type of Meal - this is the builder responsible for meal object creation
 */
sealed trait Item {
  def name: String
  def packing: Packing
  def price: Float
}
sealed trait Packing {
  def pack: String
}
abstract class Burger extends Item {
  override def name: String
  override def price: Float
  override def packing: Packing = new Wrapper
}
abstract class ColdDrink extends Item {
  override def name: String
  override def price: Float
  override def packing: Packing = new Bottle
}
class Wrapper extends Packing {
  override def pack: String = "Wrapper"
}
class Bottle extends Packing {
  override def pack: String = "Bottle"
}
class ChickenBurger extends Burger {
  override def name: String = "chicken burger"
  override def price: Float = 50.5f
}
class VeggieBurger extends Burger {
  override def name: String = "veggie burger"
  override def price: Float = 25.0f
}
class Coke extends ColdDrink {
  override def name: String = "coke"
  override def price: Float = 15.7f
}
class Pepsi extends ColdDrink {
  override def name: String = "pepsi"
  override def price: Float = 14.9f
}
//Create a Meal class by having item objects defined
class Meal {
  var items = List[Item]()
  def addItem(item: Item) = {
    items = items:+item
  }

  def getCost:Float = {
    var pricelist = List[Float]()
    pricelist = items.map(x=>x.price)
    pricelist.foldLeft(0f)((x, res)=>x+res)
  }

  def showItems() = {
    items.foreach(x => {
      println("Item: " + x.name)
      println("Price: " + x.price)
      println("Packing: " + x.packing.pack)
    })

  }

}

class MealBuilder {

  def prepareVegMeal():Meal = {
    var meal = new Meal
    meal.addItem(new VeggieBurger)
    meal.addItem(new Coke)
    meal
  }


  def prepareRegularMeal():Meal = {
    var meal = new Meal
    meal.addItem(new ChickenBurger)
    meal.addItem(new Pepsi)
    meal
  }
}

object BuilderPatternDemo extends App {

  val  mb = new MealBuilder

  val vegMeal = mb.prepareVegMeal()
  print(vegMeal.showItems())


  val regMeal = mb.prepareRegularMeal()
  println(regMeal.showItems())

}


case class Baby(grumpsLevel: Int = 0, name: String = null, eatsAsparagus: Boolean = false)

object Baby {
  
  def something = {
    val b = Baby()
    b
      .copy(grumpsLevel = 1)
      .copy(name = "xxx")
      .copy(eatsAsparagus = true)


  }
  
}



