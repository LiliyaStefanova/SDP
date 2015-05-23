package mock_exam

/**
 * Created by liliya on 19/05/2015.
 */
object IterateQ5 extends App {
  
  def iterate[T](x:T)(f:T=>T):Stream[T] = {
    
    x #:: iterate(f(x))(f)
    
  }
  
  def iterated[T](f:T=>T) :Stream[T=>T] = {
    
    ((x:T)=>x)#:: (iterated(f) map (_ andThen f))
    
  }

}
