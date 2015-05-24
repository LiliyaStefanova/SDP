package types

/**
 * Created by liliya on 20/05/2015.
 */
class PlayerSquadDivision {
  
  type Player = (String, String, Int)
  type Squad = Seq[Player]
  type Division = Seq[Squad]
  
  //Find the average age of a player in a squad

  def averageAge(sq:Squad) : Double = sq.map(x=>x._3).foldLeft(0)(_+_)/sq.length

  //Partition squad into two squads  - one with Players above and one below average age
  def partitionSquad(sq:Squad): (Squad, Squad) = sq.partition(x=>x._3>averageAge(sq))
    
  //create range - PlayerAge => NumberOfPlayersOfThisAge 
  
  //Find the number of players for each age between 19 and 23
  def range(div:Division):Map[Int, Int] = {
    
    var playerAges = Map[Int, Int]()
    
    div.foreach(x=>x.foreach(x=> { playerAges get x._3  match {
                case None => playerAges = playerAges + (x._3 -> 1)
                case Some(z) => playerAges = playerAges + (x._3 -> (playerAges(x._3)+1))
    }
    }))
    playerAges.filter(x=>x._1>=19 && x._1<=23)
  }
  
  //Find all players who are below a certain age threshold
  def keepAge(div:Division, ageBoundary:Int): Division = {
    div collect {case x => x.filter(y=>y._3<ageBoundary)}
  }
  
}

object PlayerSquadDivision extends App {
  
  val psd = new PlayerSquadDivision()
  
  //creating a player of this type
  val player = ("Didier", "Drogba", 35)

  //creating a squad of this type - can either add previously declared val or the Tuple3 direct
  val squad1 = List(player, ("Gareth", "Bales", 19), ("Dimitar", "Berbatov", 19), ("Peter", "Czech", 20))
  val squad2 = List(player, ("John", "Smith", 20), ("Lesley", "Nielsen", 20), ("Wayne", "Rooney", 21))
  val squad3 = List(player, ("Mad", "Max", 28), ("Bad", "Romance", 33), ("Corny", "Dance", 20))
  
  //creating a division made of of squads
  val division = List(squad1, squad2, squad3)

  println("Average age of players: " +psd.averageAge(squad1))
  val partitioned = psd.partitionSquad(squad1)
  
  println("The players above and below average age are: " + partitioned._1 + " and "+ partitioned._2)
  
  println("Players in the ranges between 19 and 23: "+psd.range(division))
 
  println("Players below the age threshold: "+ psd.keepAge(division, 27))
 
  
  
  
  
}
