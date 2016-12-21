package prv.ramzez.sudoku.matrix

import _root_.prv.ramzez.sudoku.UnitSpec
import _root_.prv.ramzez.sudoku.matrix.impl.ListMatrix
import org.scalatest._

/**
  * Created by Ramzez on 2016-12-21.
  */
class ListMatrixSpec extends UnitSpec {

  private val rowOne: List[Int] = List(1, 2, 7)
  private val rowTwo: List[Int] = List(3, 4, 8)
  private val rowThree: List[Int] = List(5, 6, 9)
  val m = new ListMatrix(List(rowOne, rowTwo, rowThree))

  "Empty Matrix" should "return true on isEmpty" in {
    val empty = new ListMatrix(List(List()))
    empty.isEmpty should be(true)
  }

  "Matrix" should "return elements" in {
    m(0, 0) should be(1)
    m(0, 1) should be(2)
    m(1, 0) should be(3)
    m(1, 1) should be(4)
  }

  it should "not be empty" in {
    m.isEmpty should be(false)
  }

  it should "return rows" in {
    m.getRow(0) should be(rowOne)
    m.getRow(1) should be(rowTwo)
  }

  it should "return columns" in {
    m.getColumn(0) should be(List(1, 3, 5))
    m.getColumn(1) should be(List(2, 4, 6))
  }

  it should "be equal to identical matrix" in {
    m shouldEqual new ListMatrix(List(rowOne, rowTwo, rowThree))
  }

  it should "remove rows" in {
    m.removeRow(1) shouldEqual new ListMatrix(List(rowOne, rowThree))
  }

  it should "remove columns" in {
    m.removeColumn(1) shouldEqual new ListMatrix(List(List(1, 7), List(3, 8), List(5, 9)))
  }
}
