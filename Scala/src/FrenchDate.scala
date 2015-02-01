/**
 * Created by liliya on 10/01/2015.
 */
import java.util.{Date, Locale}
import java.text.DateFormat._


object FrenchDate {

  def main(args: Array[String]): Unit ={
    val now = new Date(3, 4, 1890)
    val df = getDateInstance(LONG, Locale.FRANCE);
    println(df format now)
  }

}
