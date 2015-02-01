/**
 * Created by liliya on 10/01/2015.
 */
object ComplexNumbers {

  def main(args: Array[String]):Unit ={
    val c = new Complex(1.2, 3.4)
    val c1 = new Complex(1.6, -9.7)
    println("imaginary part: "+c.img)
    println("imaginary part 2:"+c1.img)

    println (c)
    println(c1)
  }

}
