package prv.ramzez.sudoku.matrix

import _root_.prv.ramzez.sudoku.matrix.impl.ListMatrix
import prv.ramzez.sudoku.UnitSpec

/**
  * Created by Ramzez on 2016-12-21.
  */
class ListMatrixSpec extends UnitSpec with MatrixBehaviors {
  def newMatrix(list: Seq[Seq[Int]]): Matrix[Int] =  new ListMatrix(list)

  "An empty ListMatrix" should behave like emptyMatrix(newMatrix(List(List())))

  "A ListMatrix" should behave like nonEmptyMatrix(newMatrix)
}
