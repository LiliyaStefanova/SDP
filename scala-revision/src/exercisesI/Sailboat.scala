package exercisesI

/**
 * Created by liliya on 31/01/2015.
 */
class Sailboat {

  def raise(): String ={
    "Sails raised"
  }

  def lower():String ={
    "Sails lowered"
  }

  def signal():String={
    val f = new Flare
    f.light()
  }

}

object Test{

  def main(args:Array[String]):Unit={
    val sailboat = new Sailboat
    val r1= sailboat.raise()
    assert(r1=="Sails raised", "Expected Sails raised, Got"+r1)

    val r2=sailboat.lower()
    assert(r2=="Sails lowered","Expected sails lowered, got "+r1)

    val motorboat = new Motorboat

    val s1= motorboat.start()
    assert(s1 =="Motor on", "Expected motor on, got "+s1)

    val s2= motorboat.stop()
    assert(s2=="Motor off", "Expected motor off, got "+s2)

    val sailSignal = sailboat.signal()
    assert(sailSignal=="Flare used!", "Expected Flare used!, got "+ sailSignal)

    val motorSignal = motorboat.signal()
    assert(motorSignal=="Flare used!", "Expected Flare used!, got "+motorSignal)
  }
}


