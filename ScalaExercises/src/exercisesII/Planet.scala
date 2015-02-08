package exercisesII

/**
 * Created by liliya on 08/02/2015.
 */
class Planet(name:String, description:String, moons:Int) {
  
  def hasMoons:Boolean = moons >0

}

object Planet {
  
  def main(args:Array[String]):Unit={
    
    val p = new Planet(name = "Mercury", description ="small and hot", moons = 0)
    println(p.hasMoons)

    //named parameters can be specified in any order
    val earth = new Planet(moons = 1, name = "Earth", description = "mostly harmless")
    println(earth.hasMoons)
  }
}
