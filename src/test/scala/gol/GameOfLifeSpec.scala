package gol

import org.scalatest._

class GameOfLifeSpec extends FlatSpec with Matchers {

  val rules = Map(
    true -> { aliveNeighbors: Int => (2 to 3).contains(aliveNeighbors) },
    false -> { aliveNeighbors: Int => 3 == aliveNeighbors })

  val game = new GameOfLife(rules)

  val blinkWorld = Set(Cell(Location(0, 1)), Cell(Location(1, 1)), Cell(Location(2, 1)))
  val squareWorld = Set(Cell(Location(0, 0)), Cell(Location(0, 1)), Cell(Location(1, 0)), Cell(Location(1, 1)))

  "empty world" should "remain empty" in {
    game.nextGeneration(Set()) should be(empty)
  }

  "row of 3" should "flip" in {
    val blink1: Set[Cell] = game.nextGeneration(blinkWorld)
    blink1 should have size 3
    blink1 should contain theSameElementsAs Set(Cell(Location(1, 0)), Cell(Location(1, 1)), Cell(Location(1, 2)))
  }

  "square" should "be stable" in {
    game.nextGeneration(squareWorld) should have size 4
  }

}
