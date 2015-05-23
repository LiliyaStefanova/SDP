package sample_paper

/**
 * Created by liliya on 06/05/2015.
 */
object GoldenRatio extends App {

  def estimateB(a:Double, bMin:Double, bMax:Double, err:Double):Double ={
    
    val bEst = Math.abs(bMin + bMax)/2
    val rat1 = a + bEst/a
    val rat2 = a/bEst
    val diff = rat1 - rat2
    if(Math.abs(diff) < err) bEst
    else {
      if(rat1 > rat2)  estimateB(a, bMin, bEst, err)
      else  estimateB(a, bEst, bMax, err)
    }
    
  }
  //val a = 10.0
  val a = 5.0
  val b = estimateB(a, 0, a, .000000001)
  println("B is: " + b)
  println("Estimate is: "+ a/b)
  
}
