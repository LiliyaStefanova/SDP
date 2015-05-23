/**
Example of Abstract Factory pattern in Scala
  Abstract factory defines an additional layer of abstraction in the factory by creating an AbstractFactory 
  class the purpose of which is to create new factories 
  Each factory can then create the objects needed
  */


sealed trait AbstractShape {
  def draw(): Unit
}

sealed trait AbstractColour {
  def fill(shp:AbstractShape):Unit
}

case class AbstractRectangle() extends AbstractShape {
  override def draw(): Unit = println("Draw a rectangle")
}

case class AbstractCircle() extends AbstractShape {
  override def draw(): Unit = println("Draw a circle")
}

case class Green() extends AbstractColour {
  override def fill(shp:AbstractShape): Unit = println("Fill with green "+ shp.getClass.getSimpleName)
}

case class Blue() extends AbstractColour {
  override def fill(shp:AbstractShape):Unit = println("Fill with blue " + shp.getClass.getSimpleName)
}

abstract class AbstractFactory {
  def getColour(name:String):AbstractColour
  def getShape(shpType:String):AbstractShape
  
}

object ShapeFactory extends AbstractFactory{

  def getShape(shpType: String):AbstractShape = {
    shpType match {
      case "rectangle" => new AbstractRectangle
      case "circle" => new AbstractCircle
      case _ =>  throw new MatchError("unknown shape")
    }
  }

   override def getColour(name: String): AbstractColour = null
 }

object ColourFactory extends AbstractFactory {
  override def getColour(name: String): AbstractColour = {name match {
    case "green" => new Green
    case "blue" => new Blue
    case _ => throw new MatchError("unknown colour")

  }}

  override def getShape(shpType: String): AbstractShape = null
}

object FactoryProducer{
  def getFactory(choice:String):AbstractFactory ={ choice match {
    case "shape" => ShapeFactory
    case "colour" => ColourFactory
    
  }
    
  }
  
}

object FactoryPatternDemo1 extends App {
  
  val shpFactory = FactoryProducer.getFactory("shape")
  
  val colFactory = FactoryProducer.getFactory("colour")
  
  val rec1 = shpFactory.getShape("rectangle")
  val colGreen = colFactory.getColour("green")
  rec1.draw()
  colGreen.fill(rec1)
  
  val circ1 = colFactory.getShape("circle")
  circ1.draw()


}