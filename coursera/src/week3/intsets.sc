abstract class IntSet{
  def incl(x:Int): IntSet
  def contains(x:Int):Boolean
  def union(other:IntSet):IntSet
}

//cannot instantaite IntSet
//singleton objects a re values, no need to evaluate them
object Empty extends IntSet{    //singleton -specify object instead of class
  def incl(x:Int): IntSet = new NonEmpty(x,Empty, Empty)
  def contains(x:Int):Boolean = false
  def union(other:IntSet):IntSet = other
  override def toString= "."
}

class NonEmpty(elem:Int, leftTree:IntSet, rightTree:IntSet) extends IntSet{

  def incl(x:Int): IntSet = {
    if(x<elem) new NonEmpty(elem, leftTree incl x, rightTree)
    else if(x>elem)  new NonEmpty(elem, leftTree, rightTree incl x)
    else this
  }
  def contains(x:Int):Boolean = {
    if(x<elem) leftTree.contains(x)
    else if (x>elem) rightTree.contains(x)
    else true //must be equal, we have found element
  }

  def union(other:IntSet):IntSet={
    (leftTree union rightTree) union other incl elem
  }

  override def toString = "{"+leftTree + elem + rightTree + "}"
}

val t1= new NonEmpty(3, Empty, Empty)
val t2 = t1 incl 4
