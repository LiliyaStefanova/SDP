package classesandobjects

/**
 * Created by liliya on 01/02/2015.
 */
case class Director(fName:String, lName:String, yob:Int) {

//  val firstName: String = fName
//  val lastName: String = lName
//  val yearOfBirth: Int = yob

  def name: String = {

    fName + " " + lName
  }
}

object Director{


  def older(dir1:Director, dir2:Director):Director={
    if(dir1.yob<dir2.yob) dir1 else dir2
  }
}

