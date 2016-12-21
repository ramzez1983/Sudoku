package prv.ramzez.sudoku.solver

import prv.ramzez.sudoku.matrix.Matrix

/**
  * Created by Ramzez on 2016-12-10.
  */
trait ExactCover {

  def chooseColumn(matrix: Matrix): List[Int]

  def removeRows(matrix: Matrix, r: Int): Matrix = {
    val columns: IndexedSeq[Int] = getIndexesOf1(matrix.getRow(r))
    val m1: Matrix = columns.foldLeft(matrix)((m, i) => m.removeColumn(i))
    //TODO usuwanie wierszy
    m1
  }

  def solve(currentSolution: Solution, matrix: Matrix): List[Solution] = {
    if (matrix.isEmpty) List(currentSolution)
    else {
      val col = chooseColumn(matrix)
      val rows = getIndexesOf1(col)
      rows.flatMap(r => solve(r :: currentSolution, removeRows(matrix, r))).filterNot(_.isEmpty).toList
    }
  }

  def getIndexesOf1(col: List[Int]): IndexedSeq[Int] = {
    (col.length - 1 to 0).filter(col(_) != 0)
  }
}
