package traits_and_inheritance

/**
 * Created by liliya on 20/04/2015.
 */
sealed trait Shape {
  
  val colour:Colour
  
  def sides: Int 
  def perimeter: Double
  def area: Double

}

case class Circle(radius:Double, col: Colour) extends Shape{
  
  override def sides: Int = 0

  override def perimeter: Double = 2*Math.PI*radius

  override def area: Double = Math.PI*radius*radius

  override val colour: Colour = col
}

trait Rectangular extends Shape{
  override def sides: Int = 4

  override def perimeter: Double

  override def area: Double
}

case class Rectangle(width:Double, height:Double, col:Colour) extends Rectangular{

  override def perimeter: Double = 2*(width + height)

  override def area: Double = width*height

  override val colour: Colour = col
}

case class Square(side:Double, col:Colour) extends Rectangular{

  override def perimeter: Double = 4*side

  override def area: Double = side*side

  override val colour: Colour = col
}

sealed trait Colour{
  val r:Int
  val g:Int
  val b:Int
  
  def lightOrDark():String = if((r + g + b)>150) "light" else "dark"
  
  override def toString():String = lightOrDark()
  
}

class CustomColour(red:Int, green:Int, blue:Int) extends Colour{
  
  override val r: Int = red
  override val b: Int = green
  override val g: Int = blue
  
}

class Red extends Colour{
  override val r: Int = 176
  override val b: Int = 23
  override val g: Int = 31
  
  override def toString():String = this.getClass.getSimpleName

}

class Yellow extends Colour{
  override val r: Int = 238
  override val b: Int = 238
  override val g: Int = 0
  
  override def toString():String = this.getClass.getSimpleName
}

class Pink extends Colour{
  override val r: Int = 255
  override val b: Int = 20
  override val g: Int = 147

  override def toString():String = this.getClass.getSimpleName
}


object Draw{
  
  def apply(s:Shape):String ={ s match{
    case Circle(x, c) => s"A circle of radius $x of colour $c"
    case Rectangle(x, y, c) => s"A rectangle with width $x of and height of $y of colour $c"
    case Square(x, c) => s"A square with a side of $x of colour $c"
    case _ => "Unknown"
  }
    
  }
  
  def main(args:Array[String]):Unit={
    println(Draw(Circle(10, new Yellow)))
    println(Draw(Rectangle(3, 5, new Pink)))
    println(Draw(Square(5, new Red)))
    println(Draw(Square(5, new CustomColour(23, 56, 78))))

  }
  
}

