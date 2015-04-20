//package mock_exam
//
///**
// * Created by liliya on 16/04/2015.
// */
//trait Animal
//
//private class Dog extends Animal
//
//private class Cat extends Animal
//
//
////make it an object so that it's a singleton and static - need to fix this
//object Animal {
//  def apply(type:String)=
//  {
//    type match
//    {
//      case "cat" => new Cat
//      case "dog" => new Dog
//      case _ => new MatchError("not recognized")
//    }
//  }
//
//}
//
//object MyApp extends App{
//
//  Animal("dog")
//  Animal("cat")
//
//}
