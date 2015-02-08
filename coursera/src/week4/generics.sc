import week4._

def nth[T](n:Int, list:List[T]):T= {
  if (list.isEmpty) throw new IndexOutOfBoundsException
  if (n == 0) list.head
  else nth(n - 1, list.tail)
}


val l = new Cons(1, new Cons(2, new Cons(3, new Nil)))

nth(2, l)

nth(-1, l)



