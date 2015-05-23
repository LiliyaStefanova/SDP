package collections

/**
 * Created by liliya on 22/05/2015.
 */


class Poly(terms0:Map[Int, Double]) {
  
  val terms = terms0 withDefaultValue 0.0
  def + (other:Poly) = new Poly(terms ++ (other.terms map adj))
  
  def adj(term:(Int, Double)):(Int, Double) = {
    
    val (exp, coeff) = term
    terms get exp match {
      case Some(coeff1) => exp -> (coeff + coeff1)
      case None => exp->coeff
    }
  }
  
  override def toString = (for((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
  
}

class Poly1(terms0:Map[Int, Double]) {
  //can create a constructor which allows for generation directly in format
  // (1->2.0, 3->4.0)
  def this(bindings:(Int, Double)*) = this(bindings.toMap) 
  val terms = terms0 withDefaultValue 0.0   //allows for the default value to be returned if we cannot find a matching one
  def + (other:Poly) = new Poly(terms ++ (other.terms map adj))

  def adj(term:(Int, Double)):(Int, Double) = {
    val (exp, coeff) = term
    //because we are using withdefaulValue we no longer need to pattern match on what the exponent key will return, we can
    //just go ahead and make the update 
    exp -> (coeff + terms(exp))
  }

  override def toString = (for((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
  
  def addWithFoldLeft(other:Poly1) = {
    
    new Poly1((other.terms foldLeft terms)(addTerm))
    
  }
  
  def addTerm(terms:Map[Int, Double], term: (Int, Double)) = {
    val (exp, coeff) = term
    terms + (exp -> (coeff + terms(exp)))
      
    }

}

object MapAPI extends App {

  val p1 = new Poly(Map(1->2.0, 3->4.0, 5->6.2))
  val p2 = new Poly(Map(0->3.0, 3->7.0))

  val p3 = new Poly1(1->3.0, 4->3.2, 8->6.1)
  val p4 = new Poly1(0->5.0, 4->6.8, 8->6.1)

  println(p1 + p2)
  println(p3 addWithFoldLeft p4 )
  
  val capitalsOfCountries = Map("USA"->"Washington DC", "Bulgaria"->"Sofia", "United Kingdom"->"London")
  
  println(capitalsOfCountries("USA"))
  val optionSome = capitalsOfCountries get "United Kingdom"
  val optionNone = capitalsOfCountries get "Andorra"
  
  optionSome match {

    case Some(x) => println(x)
    case None => println("not found")
    
  }

  optionNone match {

    case Some(x) => println(x)
    case None => println("not found")

  }
  
  val groupByTester = List("apple", "banana", "pear", "pineapple", "berry")
  
  println("Group by starting letter: "+ groupByTester.groupBy(_.head))
  println("Group by containing a letter: "+ groupByTester.groupBy(_ contains "a"))


}
