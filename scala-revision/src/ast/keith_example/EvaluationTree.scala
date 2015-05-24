package ast.keith_example

/**
 * Created by liliya on 21/05/2015.
 */
sealed trait EvaluationTree

final case class Term(i: Int) extends EvaluationTree

final case class Func(s: String, args: Seq[EvaluationTree]) extends EvaluationTree
  
  
object EvaluationTreeExample extends App{
//
    def eval(e:EvaluationTree):Int = ???

    def print(e:EvaluationTree):String = e match {
      case Term(i) => i.toString
      case Func(s, args) => s"Func( $s" + printThing(args, ",")
    }


    def printThing(xs:Seq[EvaluationTree], sep:String):String = xs match {
      case Nil => ""
      case y :: Nil => print(y)
      case y::ys => print (y) + sep + printThing (ys, sep)
    }

    
   val func = List(Func("add", List(Term(1), Term(2))))
     printThing(func, ",")
}


