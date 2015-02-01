package classesandobjects

/**
 * Created by liliya on 01/02/2015.
 */
/**
 * With case classes you can remove class members and refer to constructor params directly
 * Implemented proper equals and toString and hash code
 * Adds getters and setters
 * There is no need for the apply method to be defined
 * @param name
 * @param yearRelease
 * @param rating
 * @param dir
 */
case class Film(name:String, yearRelease:Int, rating:Double, dir:Director) {

//  val name:String = n
//  val yearOfRelease:Int = yearRelease
//  val imdbRating: Double = rating
//  val director: Director = dir

  def directorsAge():Int={
    yearRelease-dir.yob
  }

  def isDirectedBy(d:Director):Boolean={

    d.equals(dir)
  }

  def copy(n:String=name, yor:Int=yearRelease, rating:Double=rating, dir:Director=dir):Film={

    new Film(n, yor, rating,dir)
  }

}

object Film{

  def highestRating(f1:Film, f2:Film):Film={
    if(f1.rating>f2.rating) f1 else f2
  }

  def oldestDirectorAtTheTime(f1:Film, f2:Film):Director={
      if(f1.directorsAge()>f2.directorsAge()) f1.dir else f2.dir
  }
  
  def main(args:Array[String]):Unit={

    val eastwood = new Director("Clint", "Eastwood", 1930)
    val mcTiernan = new Director("John", "McTiernan", 1951)
    val invictus = new Film("Invictus", 2009, 7.4, eastwood)
    val predator = new Film("Predator", 1987, 7.9, mcTiernan)
    println(oldestDirectorAtTheTime(invictus, predator).name)
  }

}
