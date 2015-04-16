package mock_exam

/**
 *Example of adapter pattern
 */
object MyMain extends App {

  trait Log {

    def warning(msg: String)

    def error(msg: String)

  }

  final class Logger {

    def log(level: String, message: String): Unit = {


    }

  }
//Research on implicit meaning

 implicit class LoggerToLogAdapter(logger: Logger) extends Log {
    override def warning(msg: String): Unit = logger.log("severe", "broken")

    override def error(msg: String): Unit = logger.log("info", "broken too")
  }


  val log:Log = new Logger()
  

}
