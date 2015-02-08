//import week3._  //wildcard import
//import week3.{Rational, Hello} //list of imports
//import week3.Rational //named import

//val r = new Rational(1, 2)

def error(msg:String) = throw new Error(msg)

val x= null
val y:String = x

//val z:Int = null

//The type checker picks up 1 and else (boolean) and the most specific common
//type for both of these is AnyVal
if(true) 1 else false