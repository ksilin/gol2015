package gol

import org.scalatest.{Matchers, FlatSpec}

class GolSpec extends FlatSpec with Matchers {

//  case class Location(x: Int, y: Int)

//  val neighborOffsets = Vector((-1, -1), (0, -1), (1, -1), (-1, 0), (1, 0), (-1, 1), (0, 1), (1, 1))
//  val rules = Map(
//    true -> { aliveNeighbors: Int => (2 to 3).contains(aliveNeighbors) },
//    false -> { aliveNeighbors: Int => 3 == aliveNeighbors }
//  )
//
//  def aliveCells(cells: Iterable[Boolean]) = cells.count(identity)
//
//  def willBeAlive(alive: Boolean, aliveNeighbors: Int): Boolean = rules(alive)(aliveNeighbors)
//
//  // works for dense maps only (empty cells must be present)
//  def nextState(cells: Map[Cell, Boolean]): Map[Cell, Boolean] = {
//    cells map { case (loc: Cell, cell: Boolean) =>
//
//      val neighborLocations = neighborOffsets map { offset => Cell(loc.x + offset._1, loc.y + offset._2) }
//      val neighborCells = neighborLocations map {
//        cells.getOrElse(_, false)
//      }
//      loc -> willBeAlive(cell, aliveCells(neighborCells))
//    }
//  }
//
//  def nextStateSparse(cells: Map[Cell, Boolean]): Map[Cell, Boolean] = {
//    val allNeighbors = cells flatMap { case (loc: Cell, cell: Boolean) =>
//      neighborOffsets map { offset => Cell(loc.x + offset._1, loc.y + offset._2) }
//    }
//    val neighborsByLocation: Map[Cell, Int] = allNeighbors.groupBy(identity).mapValues(_.size)
//    val newCells: Map[Cell, Boolean] = neighborsByLocation collect {
//      case (loc, n) if willBeAlive(cells.getOrElse(loc, false), n) =>
//        (loc, true)
//    }
//    newCells
//  }
//
//  val deadWorld: Map[Cell, Boolean] = Map()
//
//  val blinkWorld: Map[Cell, Boolean] = Map(
//    Cell(0, 0) -> false, Cell(1, 0) -> false, Cell(2, 0) -> false,
//    Cell(0, 1) -> true, Cell(1, 1) -> true, Cell(2, 1) -> true,
//    Cell(0, 2) -> false, Cell(1, 2) -> false, Cell(2, 2) -> false)
//
//  val blinkSparseWorld: Map[Cell, Boolean] = Map(Cell(0, 1) -> true,
//    Cell(1, 1) -> true, Cell(2, 1) -> true)
//
//  val blinkList: List[Cell] = List(Cell(0, 1), Cell(1, 1), Cell(2, 1))
//  val squareList: List[Cell] = List(Cell(0, 0), Cell(0, 1), Cell(1, 0), Cell(1, 1))
//
//  val squareWorld: Map[Cell, Boolean] = Map(
//    Cell(0, 0) -> false, Cell(1, 0) -> false, Cell(2, 0) -> false,
//    Cell(0, 1) -> false, Cell(1, 1) -> true, Cell(2, 1) -> true,
//    Cell(0, 2) -> false, Cell(1, 2) -> true, Cell(2, 2) -> true)
//
//  val squareSparseWorld: Map[Cell, Boolean] = Map(
//    Cell(1, 1) -> true, Cell(2, 1) -> true,
//    Cell(1, 2) -> true, Cell(2, 2) -> true)
//
//
//  "empty world" should "remain empty" in {
//    val dead1: Map[Cell, Boolean] = nextState(deadWorld)
//    aliveCells(dead1.values) should be(0)
//  }
//
//  "row of 3" should "flip" in {
//    val blink1: Map[Cell, Boolean] = nextState(blinkWorld)
//    println(blink1 map { case (l, c) => l -> c })
//    aliveCells(blink1.values) should be(3)
//    blink1(Cell(1, 0)) should be(true)
//    blink1(Cell(1, 1)) should be(true)
//    blink1(Cell(1, 2)) should be(true)
//  }
//
//  "square" should "be stable" in {
//    val square: Map[Cell, Boolean] = nextState(squareWorld)
//    println(square map { case (l, c) => l -> c })
//    aliveCells(square.values) should be(4)
//  }
//
//  "empty world" should "remain empty2" in {
//    val dead1: Map[Cell, Boolean] = nextStateSparse(deadWorld)
//    aliveCells(dead1.values) should be(0)
//  }
//
//  "row of 3" should "flip2" in {
//    val blink1: Map[Cell, Boolean] = nextStateSparse(blinkSparseWorld)
//    println(blink1 map { case (l, c) => l -> c })
//    aliveCells(blink1.values) should be(3)
//    blink1(Cell(1, 0)) should be(true)
//    blink1(Cell(1, 1)) should be(true)
//    blink1(Cell(1, 2)) should be(true)
//  }
//
//  "square" should "be stable2" in {
//    val square: Map[Cell, Boolean] = nextStateSparse(squareSparseWorld)
//    println(square map { case (l, c) => l -> c })
//    aliveCells(square.values) should be(4)
//  }
}
