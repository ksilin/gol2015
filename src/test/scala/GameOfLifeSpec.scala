import org.scalatest._

class GameOfLifeSpec extends FlatSpec with Matchers {

  val neighborhoodOffsets = Set(
    Location(-1, -1), Location(0, -1), Location(1, -1),
    Location(-1, 0), Location(1, 0),
    Location(-1, 1), Location(0, 1), Location(1, 1))

  val rules = Map(
    true -> { aliveNeighbors: Int => (2 to 3).contains(aliveNeighbors) },
    false -> { aliveNeighbors: Int => 3 == aliveNeighbors })

  val game = new GameOfLife(neighborhoodOffsets, rules)

  val blinkWorld = Set(Location(0, 1), Location(1, 1), Location(2, 1))
  val squareWorld = Set(Location(0, 0), Location(0, 1), Location(1, 0), Location(1, 1))

  "empty world" should "remain empty" in {
    game.nextGeneration(Set()) should be(empty)
  }

  "row of 3" should "flip" in {
    val blink1: Set[Location] = game.nextGeneration(blinkWorld)
    blink1 should have size 3
    blink1 should contain theSameElementsAs Set(Location(1, 0), Location(1, 1), Location(1, 2))
  }

  "square" should "be stable" in {
    game.nextGeneration(squareWorld) should have size 4
  }

}
