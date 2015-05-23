package design_patterns

/**
 * Created by liliya on 26/04/2015.
 */
import scala.collection.mutable

/**
 * Composite pattern is used where we need to treat a group of object
 * in similar way as a single object
 * Composite pattern composes objects in terms of a tree structure
 * which represents part as well as the whole hierarchy
 * Comes under structural patterns and creates a tree structure of
 * a group of objects
 * In this example:
 * 1. An employee has a number of subordinates which are also employees, creating a tree structure
 * 2. The employee contains a list of employees to build up the tree
 * 
 * This is similar to what we did for Connect4, where each item(Player position) in the tree had children represented as an array 
 * of Player(position)
 */


case class Employee(name:String, dept:String, salary:Int) {

  var subordinates: mutable.MutableList[Employee] = mutable.MutableList[Employee]()

  def add(e:Employee) = subordinates.+=(e)

  def remove(e:Employee) = subordinates diff List(e)

  def getSubordinates:mutable.MutableList[Employee] = subordinates
  
  override def toString:String = s"Name: $name \nDepartment:  $dept  \nSalary: $salary"
    

}

object CompositePatternDemo extends App {

  val ceo = new Employee("John", "CEO", 300000)

  val headMarketing = new Employee("Michael", "Head marketing",200000)

  val clerk1 = new Employee("Laura", "clerk", 50000)
  val clerk2 = new Employee("Sam", "clerk", 50000)

  val salesExecutive1 = new Employee("Emily", "sales exec", 85000)
  val salesExecutive2 = new Employee("Tim", "sales exec", 80000)

  ceo.add(headMarketing)

  headMarketing.add(salesExecutive1)
  headMarketing.add(salesExecutive2)

  salesExecutive1.add(clerk1)
  salesExecutive1.add(clerk2)

  println(ceo)
  ceo.subordinates.foreach(x=>println(x))
  headMarketing.subordinates.foreach(x=>println(x))




}
