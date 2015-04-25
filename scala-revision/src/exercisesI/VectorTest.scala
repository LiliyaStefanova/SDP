package exercisesI

/**
 * Created by liliya on 31/01/2015.
 */
object VectorTest {

  def main(args:Array[String]):Unit={

    var sentence =""

    val v = Vector("The", "dog", "visited", "the", "fire", "station")

    for(a <- v){
       sentence +=a
      sentence +=" "
    }

    println(sentence)
  }

}
