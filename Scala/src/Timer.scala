import javax.security.auth.callback.Callback

/**
 * Created by liliya on 10/01/2015.
 */
object Timer {

  def oncePerSecond(callback: ()=>Unit): Unit ={
    while(true){callback();Thread sleep 100}
  }

  def main(args: Array[String]): Unit ={
    oncePerSecond(()=>println("Time flies like an arrow"))
  }

}
