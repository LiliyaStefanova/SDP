object overrides {
  
  
}


abstract  class Base {
  
  def foo = 1
  def bar:Int
}

class Sub extends Base {
  
  override def foo = 2  //must override as abstract class provided impl
  def bar = 3 //no need to override - no implementation
  
}