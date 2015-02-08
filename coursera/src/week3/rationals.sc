  val x = new Rational(1, 3)
  x.numer
  x.denom

  val y = new Rational(5, 7)
   x + y

  val z= new Rational(3, 2)
  x - y - z
  x < y    //symbolic notation
  y + y
  x max y //this is infix notation, instead of x.less(y), provided method has param
  new Rational(2)


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