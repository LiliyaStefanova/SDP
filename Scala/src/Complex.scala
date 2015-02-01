/**
 * Created by liliya on 10/01/2015.
 */
class Complex(real: Double, imaginary:Double) {

      def re = real
      def img = imaginary
      override def toString() =
      {"" + re + (if(img<0)"" else "+") +img + "i"}
}
