
/*
EmptySet and NonEmptySet conform to type IntSet. Therefore they can be used whenever an object of type
IntSet is required
All user defined Scala classes extend the java.lang Object class
 */
abstract class IntSet {

  def incl(x: Int): IntSet

  def contains(x: Int): Boolean
  
  def union(other:IntSet):IntSet

}

/* Implement IntSet as a binary tree. There are empty trees and there are trees which contain of int, 
a left subtree and a right subtree
 */

//These are called persistent data structures because even when we do changes the old
//version of the data structures are still there -i.e. include leaves the old tree there

//As we only need to define Empty once, we can use an Object, which will create a singleton class
//An object can be referred to using its name only, without having to use new
object Empty extends IntSet {

  def incl(x: Int): IntSet = new NonEmptySet(Empty, x, Empty)

  def contains(x: Int): Boolean = false

  override def toString = "."
  
  def union(other:IntSet) ={ other match{
    case Empty => Empty
    case _ => other
  }}
}

class NonEmptySet(leftTree: IntSet, x: Int, rightTree: IntSet) extends IntSet {

  def incl(y: Int): IntSet = {
    //TO keep it functional, create a new tree as part of the recursive call 
    if (y <= x) new NonEmptySet(leftTree incl y, x, rightTree)
    else if (x > y) new NonEmptySet(leftTree, x, rightTree incl y)
    else this

  }

  def contains(y: Int): Boolean = {
    if (y < x) leftTree contains y
    else if (y > x) rightTree contains y
    else true
  }
  
  override def toString = "{" + leftTree + x + rightTree + "}"
  
  def union(other:IntSet)= {other match {
    case Empty => this
    case _ =>
    
  }
    
    
  }
}

object intsets {

  val t1 = new NonEmptySet(Empty, 3, Empty)
  println(t1)
  
  val t2 = t1 incl 4
  println(t2)

}