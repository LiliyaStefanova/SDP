package poly

/**
 * Created by liliya on 29/01/2015.
 */
sealed trait Feline{
  def dinner: Food
}


//Lion, Tiger, Panther, Cat

final case class Lion() extends Feline{
  def dinner: Food =  Antelope
}

final case class Tiger() extends Feline{
  def dinner: Food = TigerStuff
}

final case class Panther() extends Feline{
  def dinner: Food = Antelope
}

final case class Cat(favFood:String) extends Feline{
  def dinner: Food = CatFood(favFood)
}

sealed trait Food
final object Antelope extends Food
final object TigerStuff extends Food
final case class CatFood(food:String) extends Food