package exercise

/**
 * Created by liliya on 15/01/2015.
 */
object TestCounter {
    def main(args:Array[String]):Unit ={
      println(new Counter(10).inc().inc(5).dec(2).count())
      println(new Counter(10).inc.inc(10).dec(2).dec.count())
      println(new Adder(5).add(2))
      val item = new Adder(5)
      item(2)
    }

}
