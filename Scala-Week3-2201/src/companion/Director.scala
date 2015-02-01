package companion

/**
 * Created by liliya on 31/01/2015.
 */
class Director(fName:String, lName:String, yob:Int) {

  val firstName: String = fName
  val lastName: String =  lName
  val yearOfBirth:Int =   yob

  def name:String ={

    firstName + " " + lastName
  }

}
