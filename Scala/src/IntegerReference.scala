/**
 * Created by liliya on 10/01/2015.
 */
object IntegerReference {

  def main(args:Array[String]): Unit ={
    val cell = new Reference[Integer]
    cell.set(13)
    println("Reference contains the half of "+(cell.get*2))
  }
}
