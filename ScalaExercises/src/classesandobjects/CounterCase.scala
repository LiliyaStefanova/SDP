package classesandobjects

/**
 * Created by liliya on 31/01/2015.
 */
case class CounterCase(num:Int) {

  var count = num

  def inc(amount:Int):CounterCase={
    new CounterCase(count+amount)
  }

  def dec(amount:Int):CounterCase={
    new CounterCase(count-amount)
  }

  def inc():CounterCase={
    new CounterCase(count+1)
  }

  def dec():CounterCase={
    new CounterCase(count-1)
  }

  def adjust(adder:Adder):CounterCase={
    new CounterCase(adder.add(count))
  }
}

object TestCounter{

  def main(args:Array[String]):Unit={

    println(new CounterCase(10).inc(5).dec.inc(6).inc.count)

    val adder = new Adder(10)

    println(new CounterCase(15).adjust(adder).count)
  }
}
