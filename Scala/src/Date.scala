/**
 * Created by liliya on 10/01/2015.
 */
class Date(y:Int, m:Int, d:Int) extends Ord{

  def year = y
  def month = m
  def day = d

  override def toString():String = year+ "-"+ month +"-"+day

  override def equals(that:Any):Boolean =
  that.isInstanceOf[Date] && {
    val o = that.asInstanceOf[Date]
    o.day == day && o.month == month && o.year == year
  }

  def <(that:Any):Boolean = {
    if(!that.isInstanceOf[Date])
      error("cannot compare "+ that + "with date")
    val o = that.asInstanceOf[Date]
    (year<o.year) || (month<o.month && day<o.day)
  }


}
