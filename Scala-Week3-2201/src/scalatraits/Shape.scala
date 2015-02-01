package scalatraits

/**
 * Created by liliya on 22/01/2015.
 */
/**
 * Create a generic trait Shape
 */
trait Shape {

  def sides():Int

  def perimeter():Double

  def area():Double

  //three abstract methods
  //sides -> number of sides
  //perimeter -> return perimeter
  //area - returns the area

  //three case clases
  //Implement Shape -> Circle, Rectangle, Square
  //user math.Pi

}

case class Circle(radius:Double) extends Shape{

  val sides:Int = 0

  val perimeter:Double = 2*math.Pi*radius

  val area: Double = math.Pi*math.Pi*radius

}

/**
 * Abstract away to ensure rectangle and square require minimum override
 */
trait Rectangular extends Shape{

  def width:Double
  def height:Double
  val sides = 4
  val perimeter:Double = 2*width +2*height
  val area:Double = width*height
}

case class Rectangle(width:Double, height:Double) extends Rectangular{

}

case class Square(side:Double) extends Rectangular{

  override val width:Double = side
  override val height:Double=side

}
