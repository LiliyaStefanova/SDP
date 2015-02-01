/**
 * Created by liliya on 10/01/2015.
 */
class Reference[T] {

  private var contents:T =_

  def set(value:T) {contents = value}

  def get:T = contents
}
