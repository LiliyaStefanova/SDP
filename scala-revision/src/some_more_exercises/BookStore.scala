package some_more_exercises

/**
 * Created by liliya on 24/05/2015.
 */
object BookStore extends App {
    
  def taxCalculator(percent:Double)(cost:Double) = cost*percent/(100+percent)
  
  def receipt(f:Double=>Double)(price:Double, d:(String, String)) = {
    val title = d._1
    val author = d._2
    val finalPrice = f(price) +price
    println(s"$title by $author, price $finalPrice")
  }
  
  receipt(taxCalculator(6))(17, ("Programming in Scala", "Martin Odersky"))
}

/*
Currying the taxCalculator function allows us to pass in the constant value
of 6 for the tax (taxCalculator(6) 
This gives back a function which takes a double and returns a double
which makes it a candidate to be used in calculating the tax 
Inside receipt therefore all we need to do is pass the price for it to be applied
to the function and to give the final price
 */