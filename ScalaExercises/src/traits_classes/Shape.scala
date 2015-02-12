package traits_classes

/**
 * Created by liliya on 08/02/2015.
 */
sealed trait Shape {

  def sides:Int
  def perimeter: Double
  def area: Double
}

object Draw{

  def apply(shp:Shape):String = {
    shp match{
      case circle:Circle => "This is a circle with a radius of " +circle.radius
      case rectangle:Rectangle => "This is a rectangle with a width " + rectangle.width + " and height "+rectangle.height
      case square:Square => "This is a square with a side " + square.side
      case _ => throw new ClassCastException
    }

  }
}

sealed trait Colour{

  def red:Int
  def green:Int
  def blue:Int

  def lightOrDark: String = if(red > 200 && green > 200 && blue > 200) "dark" else "light"
}

object Colour{
  def apply(red:Int, green:Int, blue:Int)={
    new Colour {override def green: Int = green
                override def red: Int =  red
                override def blue: Int = blue
    }
  }


object Pink extends Colour{

   val red = 230
   val green = 10
   val blue = 15

}

class Circle(val radius:Double) extends Shape {

  def sides:Int = 0
  def perimeter:Double = 2*radius*Math.PI
  def area:Double = radius*radius*Math.PI

  }

}

trait Rectangular extends Shape{

  def width:Double
  def height:Double
  def sides: Int = 4
  def perimeter:Double = 2*width + 2*height
  def area:Double = width*height
}

class Rectangle(val width:Double, val height:Double) extends Rectangular

class Square(val side:Double) extends Rectangular{

  override val width = side
  override val height = side
}

object TestDraw{
  def main(args:Array[String]):Unit={
    println(Draw.apply(new Circle(10)))
    println(Draw.apply(new Rectangle(5, 2)))
    println(Draw.apply(new Square(6)))
  }



}
