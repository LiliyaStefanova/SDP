
//the REPL

val value =17

println(value)

val v="ABCD1234"
println(v)

// v="DEF1234"
//cannot reassign to val

val num=15.56
println(num)

//Expressions

//1. true if sky is sunny and temp >80 deg

val sky ="sunny"
val temp = 90

//1.
sky=="sunny"&&temp>80

//2.
(sky=="partly cloudy"||sky=="sunny")&&(temp>80)

//3.
(sky=="partly cloudy"||sky=="sunny")&&(temp>80||temp<20)

//4.

val farh = 122
val  c_conv =(farh-32)*5/9

//5.
var cels = 50
val f_conv=(cels*9/5)+32

//Methods

//1.

def getSquare(side:Int):Int={
    side*side
}

val a= getSquare(3)
assert(a.equals(9))

val b= getSquare(6)
assert(b==36)

val c=getSquare(5)
assert(c==25)


def isArg1GreaterThanArg2(arg1:Double, arg2:Double):Boolean= {
  arg1 > arg2
}

val t1=isArg1GreaterThanArg2(4.1, .12)
assert(t1)

val t2=isArg1GreaterThanArg2(2.1, 1.2)
assert(t2)

def manyTimesString(expr:String, times:Int):String ={
  expr*times
}

manyTimesString("abcd", 2)

val m1=manyTimesString("abc", 3)
assert("abcabcabc" == m1, "Equals?")

val m2 = manyTimesString("123", 2)
assert("123123" == m2, "Equals")

//Classes and Objects

var s1:String = "Sally"

var s2:String = "Sally"

if(s1.equals(s2)) print("s1 and s2 are equal") else ("s1 and s2 not equal")

class Giraffe

val giraffe = new Giraffe

val giraffe1 = new Giraffe

val giraffe2 = new Giraffe

println(giraffe)

class Hippo

val hipp = new Hippo

println(hipp)

class Lion

val lion = new Lion

val lion1 = new Lion

println(lion)

class Tiger

val tiger= new Tiger

println(tiger)

class Monkey

val monkey = new Monkey

println(monkey)