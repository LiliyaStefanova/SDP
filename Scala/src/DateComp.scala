/**
 * Created by liliya on 10/01/2015.
 */
object DateComp {

  def main(args:Array[String]):Unit ={

    val dat = new Date(1985, 4, 15)

    val dat2 = new Date(1987, 5, 16)
    println(dat.<(dat2))
  }

}
