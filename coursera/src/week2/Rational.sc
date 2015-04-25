

class Rational(x:Int, y:Int) {
  require(y != 0, "denominator must not be 0")
  
  def this(x:Int) = this(x, 1)
  
  private def gcd(a:Int, b:Int):Int = if(b==0) a else gcd(b, a%b)
  
  private val g = gcd(x, y)
  
  def numer = x/g
  def denom = y/g
  
  
  def <(that:Rational):Boolean = this.numer*that.denom < that.numer*this.denom
  
  def + (that:Rational):Rational = new Rational(this.numer*that.denom + that.numer*this.denom, this.numer*that.denom)
  
  def - (that:Rational):Rational = this + -that
  
  def max(that:Rational):Rational = if(this.<(that)) that else this
  
  def min(that:Rational):Rational = if(this.<(that)) this else that
  
  //neg is called unary_- to provide prefix operator for negative to not clash with -
  //ensure a space is provided between unary and : as otherwise : will be concatenated with the rest of the operator
  def unary_- :Rational = new Rational(-numer, denom)
  
  override def toString = s"$x/$y"
  
}

val x = new Rational(1, 2)
val y = new Rational(2, 3)

x.numer
y.denom
//[1/x, 2/y][] [new Rational(1, 2)/this] x

 x < y
//[1/x, 2/y][] [new Rational(1, 2)/this][new Rational(2,3)/that]

x + y

x  max y

