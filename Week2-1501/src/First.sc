object First{
  println("Welcome to the worksheet")
  3+3
  7.min(6).min(5)
  if(20>10) "left" else "right"
  if(10>14) "left"
  println("str an something =" + "something else = "+ 34)

  assert(square(2.0) == 4)
  assert(square(3.0)==9)


  def square(in:Double): Double={
        in*in
  }

}