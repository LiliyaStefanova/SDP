/**
Example of Factory pattern in Scala
  This is a creational pattern which is used to provide the best way to create
  an object. 
  With Factory pattern, an object is created without exposing the creation
  logic to the client and refer to newly created object using a common interface
  Step 1: Create an interface
  Step 2: Create concrete classes implementing the interface
  Step 3: Create a factory to generate object of concrete class given specified info
  
  In this instance the implementation uses a sealed trait with case classes
  extending it. 
  The factory is implemented as an object, making it a static factory
  If it were a class, a new instance of the factory will have to be created
 */


sealed trait Shape {
  def draw(): Unit

}

case class Rectangle() extends Shape {
  override def draw(): Unit = println("Draw a rectangle")
}

case class Circle() extends Shape {
  override def draw(): Unit = println("Draw a circle")
}


object ShapeFactory {

  def getShape(shpType: String):Shape = {
    shpType match {
      case "rectangle" => new Rectangle()
      case "circle" => new Circle()
      case _ =>  throw new MatchError("unknown shape")
    }
  }

}

object FactoryPatternDemo extends App {

  val rec = ShapeFactory.getShape("rectangle")
  rec.draw()
  
  val circ = ShapeFactory.getShape("circle")
  rec.draw()


}