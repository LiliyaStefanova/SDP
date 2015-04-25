package exercisesI

/**
 * Created by liliya on 31/01/2015.
 */
object Operations {

  def main(args:Array[String]):Unit={

    val vint = Vector(4, 6, 8, 1, 56)
    val vdouble = Vector(1.4, 5.6, 8.9, 7.0)


    println("Int's sum:" + vint.sum)
    println("Double's sum:" + vdouble.sum)

    println("Int's max: " + vint.max)
    println("Double's max:" + vdouble.max)

    println("Int's min:" + vint.min)
    println("Double's min:" + vdouble.min)

    val myVector1 = Vector(1, 2,3, 4, 5, 6)
    val myVector2 = Vector(1, 2, 3, 4, 5, 6)
    //TODO need to use the atomic test to prove these are equivalent
  }

}
