package exercise

/**
 * Created by liliya on 15/01/2015.
 */
class Film(val name: String,
           yearOfRelease: Int,
           imdbRating: Double,
           val director: Director) {


  def directorsAge = yearOfRelease - director.dateOfBirth

  def isDirectedBy(dir: Director): Boolean = this.director == dir //can leave out Boolean as it's inferred

  def copy(name: String = this.name,
           yearOfRelease: Int = this.yearOfRelease,
           imdbRating: Double = this.imdbRating,
           director: Director = this.director): Film = {
    new Film(name, yearOfRelease, imdbRating, director)

  }

  //copy method accepts same formal params as the constructor and returns a new copy of the film
  //give each parameter default values = the existing values for this film
}
