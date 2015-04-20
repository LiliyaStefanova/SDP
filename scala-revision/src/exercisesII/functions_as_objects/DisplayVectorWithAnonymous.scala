package exercisesII.functions_as_objects

import exercisesII.AtomicTest._

/**
 * Created by liliya on 19/04/2015.
 */
object DisplayVectorWithAnonymous {

  def main(args: Array[String]): Unit = {

    val v = Vector(1, 2, 3, 4)

    displayAsString(v) is "1234"

    val v2 = Vector(1, 2, 3, 4)

    displayAsStringWithCommas(v2) is "1, 2, 3, 4, "

  }

  def displayAsStringWithCommas(v: Vector[Int]): String = {

    var s = ""
    v.map(x => s += x.toString + ", ")
    s
  }

  def displayAsString(v: Vector[Int]): String = {

    var s = ""
    v.map(x => s += x.toString)
    s
  }

}

object DogYears extends App {

  val dogYears = (x: Int) => x * 7
  dogYears(10) is 70

  var s = ""
  val v = Vector(1, 5, 7, 8)
  v.foreach(x => s += dogYears(x).toString + " ")
  s is "7 35 49 56 "

}


  

