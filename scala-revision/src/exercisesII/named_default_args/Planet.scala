package exercisesII.named_default_args

import java.awt.print.Book

/**
 * Created by liliya on 19/04/2015.
 */
case class Planet(name:String, description:String, moons:Int = 1) {

  def hasMoon:Boolean = moons>0
}

object Planet extends  App{
  
  val p = new Planet(name="Mercury", description="hot and small", moons = 0)
  println(p.hasMoon)
  
  //Order of arguments specified to create a class does not matter
  val earth = new Planet(moons= 1, name="Earth", description = "mostly harmless")
  println(earth.hasMoon)
}
