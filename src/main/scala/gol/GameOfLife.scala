package gol

case class Location(x: Int, y: Int) {
  def +(other: Location): Location = Location(x + other.x, y + other.y)
}

case class Cell(loc: Location, neighborhoodOffsets: Set[Location] = defaultOffsets) {
  lazy val neighbors = neighborhoodOffsets map { loc + _ }
}

class GameOfLife(rules: Map[Boolean, Int => Boolean]) {

  def nextGeneration(livingCells: Set[Cell]): Set[Cell] = {
    locationsWithAliveNeighbors(livingCells).groupBy(identity).mapValues(_.size).collect {
      case (loc, aliveNeighbors) if willBeAlive(isAliveAt(livingCells, loc), aliveNeighbors) => Cell(loc)
    }.to[Set]
  }

  def willBeAlive(isAlive: Boolean, aliveNeighbors: Int): Boolean = rules(isAlive)(aliveNeighbors)
  
  def isAliveAt(livingCells: Set[Cell], loc: Location): Boolean = livingCells exists { _.loc == loc }

  def locationsWithAliveNeighbors(livingCells: Set[Cell]): List[Location] = livingCells.to[List] flatMap { _.neighbors }
}
