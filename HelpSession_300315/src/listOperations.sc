
//an item consed onto a list which contains item consing onto a list
val fruits = "apples" :: ("oranges" :: ("pears" :: Nil))

val fruitList1 = List("Mangoes", "Figs")
val fruitList2 = List("Pineapples", "Apples")
val fruitList = fruitList1:::fruitList2   //research operators
"an item" :+ fruitList2
"an item " + fruitList2

fruitList2.isEmpty
fruitList.head
fruitList.tail  //the tail is the remainder of the list

fruitList match {
    //h:: t pulls apart the list head
  case h::t => {
    println(h + " is in the head")
    println(t)
  }
  
}

val leftList = List(1, 2,3)
val rightList = List(4, 5, 6)

leftList zip rightList

val stringList = List("a, b, c, d")
leftList zip stringList

//starting with a value of 0, take the first two items and add it together
//feed this into the next value of the list and add them together again
//0 is like an accumulator and a starting value
leftList.foldLeft(0)((x, y)=>x+y)

//equivalent of the above
//but meaning of the values is reversed
leftList.foldRight(0)(_ + _ )

leftList.foldLeft(0)(_+_)/leftList.foldLeft(0)((x, y)=>x+1)

//take a list and applies a function to it
leftList.map(n=>n * n)

//takes the head of the list as the starter value
leftList.reduce((x, y)=>x+y)
rightList.reduce(_+_)

//apply a filter before reducing
leftList.filter(_<3).reduce(_+_)

//tuples
//can be of mixed types
//good if you want to return a tuple that consists of multiple types
//can pull apart using a pattern matcher to do it

var x=  (1.1, 2, "hi")
x._1
x._2
x._3

val aMap = Map(1->2)

for { item<-leftList
    if item % 2 == 0
}  yield item   //item is yielded as a list