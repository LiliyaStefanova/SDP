package exercisesI

/**
 * Created by liliya on 31/01/2015.
 */
case class Cup(pFull:Int) {

  var percentFull = pFull
  val max = 100

  def add(increase:Int):Int ={
    percentFull+=increase
    if(percentFull>max){
      percentFull = max
    }
    percentFull //returns
  }

}
//TODO need to come back to this and finish off the test class
object TestCup{

  def main(args:Array[String]):Unit={

    val cup = new Cup(0)
    cup.add(45)
    cup.add(-15)

    cup.percentFull=67
    println(cup.percentFull)


  }
}
