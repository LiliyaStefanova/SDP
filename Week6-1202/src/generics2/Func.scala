package generics2

/**
 * Created by liliya on 12/02/2015.
 */
object Func extends App {

  def part[A, B, C](a:A, fn:(A, B)=>C):B => C = {

    (b:B) => fn(a, b) //currying -function b of type B returns a function fn(a, b) that returns C
  }

  def compose[A, B, C](f:B =>C, g:A=>B):A =>C = {
    a:A => f(g(a))    //g returns b, if we apply f to g we get a C, we pass in A which is the param of compose and of g
  }

  def f = (x:Double) => math.Pi /2-x
  def cos = f andThen math.sin

  f compose cos

  val double = (x:Double) => 2.0*x

  val squared = (x:Double) =>x * x

  val a=3
  val x = part(a:Int,(a:Int, b:Int)=>a+b )  //returns a function that adds 3
  val add6 = part(6, (a:Int, b:Int) =>a+b)
  println(x(6))

 // val  v = compose(double, squared)
  val v = double compose squared
  println((double compose squared) (10))
  println(v(3))

}


