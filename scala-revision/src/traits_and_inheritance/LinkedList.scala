package traits_and_inheritance


/**
 * Created by liliya on 21/04/2015.
 */
sealed trait LinkedList[A] {

  val head: Option[A]
  val tail: LinkedList[A]

  def length(): Int

 // def apply: A

  def contains(x:A): Boolean

}

case class Pair[A](theHead:A, tail: LinkedList[A]) extends LinkedList[A] {


  override val head: Option[A] = Some(theHead)

  override def length(): Int = {
    helperLength(head, tail)
  }
  

  override def contains(x: A): Boolean = {
    helperContains(x, head, tail)
  }
  
  def helperLength(head:Option[A], tail:LinkedList[A]):Int ={ 
  if(head == None)  0
  else 1 + helperLength(tail.head, tail.tail)
  }
  
  def helperContains(x:A, head:Option[A], tail:LinkedList[A]):Boolean ={
    if(x == head.get) true
    else helperContains(x, tail.head, tail.tail)
    
  }

}

case class Empty[A]() extends LinkedList[A] {
  override def length(): Int = 0

  override def contains(x: A): Boolean = false

  override val head: Option[A] = None
  override val tail: LinkedList[A] = this
}

object Linked extends App {

  val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, Empty[Int]())))

  println(list.isInstanceOf[LinkedList[Int]])

  println(list.head.get)
  println(list.tail.head.get)
  println(list.tail.tail.head.get)

  println(list.length())

  println(list.contains(2))

}


