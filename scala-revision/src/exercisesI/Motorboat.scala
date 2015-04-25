package exercisesI

/**
 * Created by liliya on 31/01/2015.
 */
class Motorboat {

  def start(): String ={
    "Motor on"
  }

  def stop():String={
  "Motor off"
  }

  def signal():String ={
    val flare = new Flare
    flare.light()
  }

}
