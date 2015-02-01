package exercisesI

/**
 * Created by liliya on 31/01/2015.
 */
class Flare {

  def light():String ={
    "Flare used!"
  }
}

object TestFlare{

  def main(args:Array[String]):Unit={
      val flare = new Flare
      val f1 = flare.light()
      assert(f1 =="Flare used!", "Expected Flare used!, got "+f1);


  }
}