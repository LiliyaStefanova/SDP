/**
 * Created by liliya on 10/01/2015.
 */
trait Ord {

  def < (that:Any):Boolean
  def <= (that:Any): Boolean = (this < that) || (this == that)
  def > (that:Any): Boolean = !(this<=that)
  def >= (that:Any): Boolean = !(this<that)


}
