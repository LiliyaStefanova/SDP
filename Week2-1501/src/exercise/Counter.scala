package exercise

/**
 * Created by liliya on 15/01/2015.
 */
class Counter(val counter: Int) {

  def inc(amount: Int = 1) = new Counter(counter + amount)

  def inc: Counter = inc()

  def dec(amount: Int = 1) = new Counter(counter - amount)

  def dec: Counter = dec()

  def count() = counter

  def adjust(adder: Adder) = new Counter(adder.add(counter))

}

//add counter to adder

class Adder(amount: Int) {
  def add(in: Int) = in + amount

  def apply(in: Int) = in + amount
}


object Counter extends App {
  println(new Counter(10).inc().inc(5).dec(2).count())
  println(new Counter(10).inc.inc(10).dec(2).dec.count())
  println(new Adder(5).add(2))
  val item = new Adder(5)
  item(2)

}