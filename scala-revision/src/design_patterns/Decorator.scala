package design_patterns

/**
 * Allows to add new functionality to an existing class without altering its structure 
 * Comes under structural patterns - adds a wrapper to an existing class* 
 */

class Decorator {

}

trait ShapeDec {
  def draw()
  
}


class RecDec extends ShapeDec {
  
  override def  draw() = println("Shape: rectangle")
  
}

class CircDec extends ShapeDec {
  
  override def draw() = println("Shape:circle")
  
}

abstract case class ShapeDecorator(decoratedShape:ShapeDec) extends ShapeDec {
  
  def draw() = decoratedShape.draw()
  
}

class RedShapeDecorator(decoratedShape:ShapeDec) extends ShapeDecorator(decoratedShape:ShapeDec) {
  
  override def draw(): Unit ={ 
    decoratedShape.draw()
    setRedBorder(decoratedShape)
  }
  
  def setRedBorder(shp:ShapeDec) = println("Border control: red")
  
}

object DecoratorPatternDemo extends App {
  
  val circle = new CircDec
  circle.draw()
  
  val redCircle = new RedShapeDecorator(circle)
  
  redCircle.draw()
  
  
}

