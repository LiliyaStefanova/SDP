package mock_exam

/**
 * Created by liliya on 16/04/2015.
 */

//First item is x, second f(x), etc
//So if you always tack to a front of a list what the first parameter of the call (x:T) is, the stream will be generate
//Q about recursion not streams
class Question5 {
  
  def iterate[T](x: T)(f: T => T): Stream[T] = {
  //Hash means to treat it as a list
       x #:: iterate(f(x))(f) }
  
  def iterated[T](f: T => T): Stream[T => T] = {
    //   iterate((x:T)=>x)(_andThen f)
    //(x:T) => x -identity function
    ((x: T) => x) #:: (iterated(f) map (_ andThen f))
  }

}
