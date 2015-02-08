package week4

import java.util.NoSuchElementException

/**
 * Created by liliya on 08/02/2015.
 */
trait List[T] {

  def isEmpty:Boolean
  def head:T
  def tail:List[T]
}

//Cons lists elements are defined in terms of head with a value and a pointer to the rest of the list
//val head:Int defines a parameter and a field definition at the same time

class Cons[T](val head:T, val tail:List[T]) extends List[T]{
  def isEmpty = false //cons cells are never empty
  //val head:T is a legal implementation of a def
  //definitions and classes are special cases of methods and can override them
  //val is evaluated only when it is first defined, def is evaluated every single time
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head:Nothing  = throw new NoSuchElementException("Nil.head")  //Nothing is a subtype of T
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}  //defines empty list

object List {
  //List(1, 2) = List.apply(1, 2)
  def apply[T]() = new Nil

  def apply[T](x1:T) = new Cons(x1, new Nil)

  def apply[T](x1:T, x2:T):List[T] = new Cons(x1, new Cons(x2, new Nil))

  def main(args:Array[String]):Unit={
    val l= List(1)
    println(l)
    val l1 = List(4, 5)
    println(l1)
  }
}




