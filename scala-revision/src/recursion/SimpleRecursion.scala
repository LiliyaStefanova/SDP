package recursion

import scala.annotation.tailrec

/**
 * Created by liliya on 24/05/2015.
 */
object SimpleRecursion extends App {

  //Sum of elements in a list - regular recursion
  def sum(list: List[Int]): Int = list match {
    case Nil => 0
    case List(x) => x
    case x :: xs => x + sum(xs)
  }

  println("Sum rec: " + sum(List(1, 4, 6)))

  //Sum of elements in a list - tail recursion
  def sum1(list: List[Int]): Int = {
    @tailrec
    def helper(xs: List[Int], acc: Int): Int = xs match {
      case Nil => acc
      case y :: ys => helper(ys, y + acc)
    }
    helper(list, 0)
  }

  println("Sum tail rec:" + sum1(List(1, 4, 6)))


  //Product of elements in a list - regular recursion
  def product(list: List[Int]): Int = list match {
    case Nil => 1
    case List(x) => x
    case x :: xs => x * product(xs)
  }

  println("Product rec:" + product(List(1, 4, 6)))

  //Product of elements in a list - tail recursion
  def product1(list: List[Int]): Int = {
    @tailrec
    def helper(xs: List[Int], acc: Int): Int = xs match {
      case Nil => acc
      case y :: ys => helper(ys, y * acc)
    }
    helper(list, 1)
  }

  println("Product tail rec:" + product1(List(1, 4, 6)))

  //Fibonacci - regular recursion 
  def fibonacci(n: Int): Int = n match {
    case 0 => 1
    case 1 => 1
    case _ => fibonacci(n - 1) + fibonacci(n - 2)

  }

  println("Fib rec:" + fibonacci(4))

  //Fibonacci tail  rec
  def fibonacciTailRec(n: Int): Int = {

    def helper(x: Int, previous: Int = 0, next: Int = 1): Int = x match {
      case 0 => previous
      case 1 => next
      case _ => helper(x - 1, next, previous + next)

    }
    helper(n) //no need to pass others in as they have been given default values
  }

  println("Fib tail rec:" + fibonacciTailRec(4))


  //Factorial - recursive 

  def factRecursive(n: Int): Int = {
    if (n < 2) 1
    else n * factRecursive(n - 1)
  }

  println("Fact recursive:" + factRecursive(5))

  //Factorial - tail recursive 

  def factTailRecursive(n: Int): Int = {
    @tailrec
    def helper(x: Int, acc: Int): Int = {
      if (x < 2) acc
      else helper(x - 1, x * acc)

    }
    helper(n, 1)
  }

  println("Fact tail recursive:" + factTailRecursive(5))

  //GCD
  //If b == 0 then we have found it, else, find
  @tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  println("GCD of numbers:" + gcd(12, 18))

  //Sum of values in range a to b with a function applied to a before each sum => equivalent to map and then sum
  def sumOfRanges(f: Int => Int)(a: Int, b: Int): Int = {
    @tailrec
    def helper(a: Int, acc: Int): Int = {
      if (a > b) acc
      else helper(a + 1, f(a) + acc)
    }
    helper(a, 0)
  }


  println("Sum squares in range:" + sumOfRanges(x => x * x)(5, 10))

  //Products of values in range a to b (equivalent to reduce _*_) with a function applied to each value first
  def productOfRanges(f: Int => Int)(a: Int, b: Int): Int = {
    def helper(a: Int, acc: Int): Int = {
      if (a > b) acc
      else helper(a + 1, acc * f(a))
    }
    helper(a, 1)
  }

  println("Product of range:" +productOfRanges(x => x * 2)(5, 10))


}