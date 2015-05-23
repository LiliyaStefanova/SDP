//map, filter, reduce, fold and collect are high order functions
//make sure you know them!

var xs:Seq[Int] = List(1, 3, 5, 6, 8)

xs filter (x=>x>5)
xs filter (x=> !(x>5))
def partition(x:Seq[Int])

val ys, zs:(Seq[Int], Seq[Int]) = xs partition (x=>x>5)

xs take 3

xs drop 3

xs fold 0_+_

//take
//drop
//prob won't need collect
//for each and for all
//prepend and append
//reduce 

def f(x:Int, y:Int) = x + y
f(3, 4)

def ff(x:Int)(y:Int) = x + y

ff(3)(4)
val x = ff(3)_  //x is now a function which takes an int and returns and int

x
x(4)  //apply the x function to 
x(5)

//more marks for currying 
//no lazy eval
//no streams in Scala - only for Java 8
//nothing as hard as pie and mash
//Keith to provide an answer

//what sort of pattern would you use to implement singleton - factory
//Given an example of where it is appropriate to use and observer pattern
