package traits_and_inheritance


/**
 * Created by liliya on 21/04/2015.
 */
sealed trait LinkedList[A] {
  
  //define head as an Option[A] to be able to handle None for empty list
  val head: Option[A]
  val tail: LinkedList[A]

  def length(): Int

  def apply(n: Int): A

  def contains(x: A): Boolean

}

case class Pair[A](theHead: A, tail: LinkedList[A]) extends LinkedList[A] {

  //the value of head needs to be retrieved from the option
  override val head: Option[A] = Some(theHead)

  override def length(): Int = {
    helperLength(head, tail)
  }
  
  override def contains(x: A): Boolean = {
    helperContains(x, head, tail)
  }

  def apply(n: Int): A = if (n > this.length) throw new Exception("Out of bounds!") else helperFinder(n, this)

  //define function recursively
  def helperLength(head: Option[A], tail: LinkedList[A]): Int = {
    if (head == None) 0
    else 1 + helperLength(tail.head, tail.tail)
  }
  
  //define function recursively
  def helperContains(x: A, head: Option[A], tail: LinkedList[A]): Boolean = {
    if (x == head.get) true
    else helperContains(x, tail.head, tail.tail)

  }
  //define function recursively
  def helperFinder(n: Int, l: LinkedList[A]): A = {
    if (n == 0) l.head.get
    else helperFinder(n - 1, l.tail)

  }

}

case class Empty[A]() extends LinkedList[A] {
  override def length(): Int = 0

  override def contains(x: A): Boolean = false

  def apply(n: Int): A = head.get

  override val head: Option[A] = None //an option with no value for the head
  override val tail: LinkedList[A] = this //the tail is an empty list and hence this
}

object Linked extends App {

  //Create the list
  val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, Empty[Int]())))
  val checkContains = 3
  val position = 1

  println("The head of the list: " + list.head.get)
  println("The head of the tail of the list:" + list.tail.head.get)
  println("The head of the tail of the tail of the list: " + list.tail.tail.head.get)

  println("List length:" + list.length())

  println(s"List contains $checkContains:" + list.contains(3))

  println(s"Element at position $position: " + list.apply(1))

}


