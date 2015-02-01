package exercise

/**
 * Created by liliya on 15/01/2015.
 */
class Director(val firstName: String,
val lastName:String,
val dateOfBirth:Int) {


  def name = {
    s"$firstName $lastName" //shorthand for defining strings
  }
  def copy(
    firstName: String=firstName,
    lastName:String = lastName,
    dateOfBirth: Int = dateOfBirth) =
    new Director(firstName, lastName, dateOfBirth)

}
