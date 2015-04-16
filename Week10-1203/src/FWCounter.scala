import akka.actor._
import akka.util.Timeout

/**
 * Created by liliya on 12/03/2015.
 */

case class StartProcessingFile()

case class ProcessLineMessage(line: String)

case class ProcessedLine(words: Int)

class FileOfWordsCounter(filename: String) extends Actor {
  private var running = false
  private var fileSender: Option[ActorRef] = None
  private var lineCounter = 0
  private var runningTotal = 0
  private var linesProcessed = 0

  def receive = {
    case StartProcessingFile =>
      if (running) {
        println("Start running")
      }
      else {
        println("started running")
        running = true
        fileSender = Some(sender) //save ref to parent process

        import scala.io.Source._
        fromFile(filename).getLines().foreach {
          line => context.actorOf(Props[WordCounterActor], "wactor," + lineCounter) ! ProcessLineMessage(line)
            println("Starting actor " + "wactor" + lineCounter)
            lineCounter += 1

        }
      }
    case ProcessedLine(words) =>
      runningTotal += words
      linesProcessed += 1
      if (linesProcessed == lineCounter) {
        fileSender.map(_ ! runningTotal) //take the running total back to the sender

      }
    case _ => println("random")
  }


}

class WordCounterActor extends Actor {

  override def receive = {
    case ProcessLineMessage(line) =>
      val wordsInLine = line.split(" ").length
      sender ! ProcessedLine(wordsInLine)
    case _ => println("aaah!")

  }
}

import akka.pattern.ask
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object LineCounter extends App {
  val system = ActorSystem("wordCounterSystem")
  val actor = system.actorOf(Props(new FileOfWordsCounter(args(0))), "file")  //need to specify the file in configuration
  implicit val timeOut = Timeout(30 seconds)
  val future = actor ? StartProcessingFile //ask 
  future.map{ result => println("Total number of words is: "+result)}
  system.shutdown()

}
