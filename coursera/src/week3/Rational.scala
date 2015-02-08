package week3 //packages as normal


class Rational(x:Int, y:Int){

  require(y!=0, "denominator must be non-zero")   //enforce pre-condition on creator of a class
  private def gcd(a:Int, b:Int):Int = if(b==0) a else gcd(b, a%b)
  def numer = x
  def denom = y

  def this(x:Int) = this(x, 1) //second constructor implementation

  def + (that:Rational)= //the left operand is the number for which we define the class
    new Rational(numer*that.denom + that.numer*denom,
      denom*that.denom)

  def unary_- :Rational = new Rational(-numer, denom)

  //leverage the old format
  def - (that:Rational):Rational =  this + -that  //using symbolic operators

  def < (that:Rational)= this.numer*that.denom < that.numer*this.denom

  def max(that:Rational) = if(this < that) that else this


  override def  toString = {
    val g = gcd(numer, denom) //better to normalize numbers as early as possible
    numer/g + "/" + denom/g
  }
}