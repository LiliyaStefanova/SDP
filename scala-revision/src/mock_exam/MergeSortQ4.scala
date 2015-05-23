package mock_exam

/**
 * Created by liliya on 19/05/2015.
 */
object MergeSortQ4 extends App{
  
  
  def merge[T](as:List[T], bs:List[T])(cmp:(T, T)=>Boolean):List[T] = (as, bs) match {
    case (Nil, _) => bs
    case (_, Nil) => as
    case (x::xs, y::ys) => if(cmp(x, y)) x::merge(xs, bs)(cmp)
                           else y::merge(as, ys)(cmp)
    
  }
  
  println(merge(List(1, 4, 7, 10, 11), List(2, 3, 5, 7, 12, 16))((x, y)=>x<=y))
  
  def merge2[T](as:List[T], bs:List[T])(cmp:(T, T)=>Boolean):List[T] = {
    
    def mergeHelper(la:List[T], lb:List[T], acc:List[T])(cmp:(T, T)=>Boolean):List[T] = (la, lb) match {

      case (Nil, _) => acc ++ lb
      case (_, Nil) => acc ++ la
        case(x::xs, y::ys) => if(cmp(x, y)) mergeHelper(xs, lb, acc:+x)(cmp)
                              else mergeHelper(la, ys, acc:+y)(cmp)
      
    }
    mergeHelper(as, bs, List())(cmp)
    
  }

  println(merge2(List(1, 4, 7, 10, 11), List(2, 3, 5, 7, 12, 16))((x, y)=>x<=y))

}
