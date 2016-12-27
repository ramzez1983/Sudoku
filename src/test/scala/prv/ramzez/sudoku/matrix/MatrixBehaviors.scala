package prv.ramzez.sudoku.matrix

import org.scalatest._
import prv.ramzez.sudoku.UnitSpec

/**
  * Created by lukasz.wolanski on 27.12.2016.
  */
trait MatrixBehaviors {this: UnitSpec =>

  val rowOne: List[Int] = List(1, 2, 7)
  val rowTwo: List[Int] = List(3, 4, 8)
  val rowThree: List[Int] = List(5, 6, 9)

  def emptyMatrix(matrix: => Matrix[Int]) {
    it should "return true on isEmpty" in {
      matrix.isEmpty should be(true)
    }
  }

  def nonEmptyMatrix(newMatrix: List[List[Int]] => Matrix[Int]) {
    def m = newMatrix(List(rowOne,rowTwo,rowThree))

    it should "return elements" in {
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
      m shouldEqual newMatrix(List(rowOne, rowTwo, rowThree))
    }

    it should "remove rows" in {
      m.removeRow(1) shouldEqual newMatrix(List(rowOne, rowThree))
    }

    it should "remove columns" in {
      m.removeColumn(1) shouldEqual newMatrix(List(List(1, 7), List(3, 8), List(5, 9)))
    }
  }
}
