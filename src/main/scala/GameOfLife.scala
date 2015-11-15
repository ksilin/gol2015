
case class Location(x: Int, y: Int) {
  def +(other: Location): Location = new Location(x + other.x, y + other.y)
}

class GameOfLife(neighborhoodOffsets: Set[Location], rules: Map[Boolean, Int => Boolean]) {

  def willBeAlive(isAlive: Boolean, aliveNeighbors: Int): Boolean = rules(isAlive)(aliveNeighbors)

  def nextGeneration(livingCells: Set[Location]): Set[Location] = {
    locationsWithAliveNeighbors(livingCells).groupBy(identity).mapValues(_.size).collect {
      case (loc, aliveNeighbors) if willBeAlive(livingCells.contains(loc), aliveNeighbors) => loc
    }.to[Set]
  }

  def locationsWithAliveNeighbors(livingCells: Set[Location]): List[Location] = {
    livingCells.to[List] flatMap { location =>
      neighborhoodOffsets map { _ + location }
    }
  }

  def nextGenerationExplicit(livingCells: Set[Location]): Set[Location] = {
    val aliveNeighborsPerCell: Map[Location, Int] = locationsWithAliveNeighbors(livingCells)
      .groupBy(identity).mapValues { livingNeighbors: List[Location] => livingNeighbors.size }
    aliveNeighborsPerCell.collect {
      case (cell: Location, aliveNeighbors: Int) if willBeAlive(livingCells.contains(cell), aliveNeighbors) => cell
    }.to[Set]
  }
}
