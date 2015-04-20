package exercisesII.parameterized_types

import exercisesII.AtomicTest._

/**
 * Created by liliya on 19/04/2015.
 */
class ParameterizedReturnTypes {

  // Return type is inferred:
  def inferred(c1: Char, c2: Char, c3: Char) = {
    Vector(c1, c2, c3)
  }

  // Explicit return type:
  def explicitVector(d1: Double, d2: Double, d3: Double): Vector[Double] = {
    Vector(d1, d2, d3)
  }

  def explicitList(v: Vector[Number]): List[Double] = {
    val list = v.toList

    list.map(x => x.doubleValue())
  }
  
  def explicitSet(v:Vector[Number]):Set[Double] = {
    
    val set = v.toSet
    set.map(x=>x.doubleValue())
    
  }

}

  object ParameterizedReturnTypes extends App{
    
    val parm = new ParameterizedReturnTypes
    parm.inferred('a', 'b', 'c') is
      "Vector(a, b, c)"
    parm.explicitVector(1.0, 3.4, 5.7) is
      "Vector(1.0, 3.4, 5.7)"

    parm.explicitList(Vector(10.0, 20.0)) is List(10.0, 20.0)

    parm.explicitList(Vector(1, 2, 3)) is List(1.0, 2.0, 3.0)
    
    parm.explicitSet(Vector(10.0, 20.0, 10.0)) is Set(10.0, 20.0)
    parm.explicitSet(Vector(1, 2, 3, 2, 3, 4)) is Set(1.0, 2.0, 3.0, 4.0)

}
