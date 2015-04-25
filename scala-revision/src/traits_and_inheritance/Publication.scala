package traits_and_inheritance

/**
 * Created by liliya on 20/04/2015.
 */
trait Publication {

}

trait Manuscript {
  
  val length:Int
  val author:String
}

//mixin
//TODO check if it makes sense for these to be abstract classes and if not - how to best implement vals?

abstract class Book extends Manuscript with Publication {
}

abstract class Periodical extends Publication {
  
  val editor: String
  val issues: Seq[Issue]
}

abstract class Issue(volume:Int, number:Int){
  
  val content: Seq[Manuscript]
  
}


