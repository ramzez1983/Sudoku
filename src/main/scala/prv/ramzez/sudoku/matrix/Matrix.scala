package prv.ramzez.sudoku.matrix

/**
  * Created by Ramzez on 2016-12-21.
  */
trait Matrix extends ((Int, Int) => Int) {
  def apply(row: Int, column: Int): Int

  def isEmpty: Boolean

  def getColumn(column: Int): List[Int]

  def removeColumn(column: Int): Matrix

  def getRow(row: Int): List[Int]

  def removeRow(row: Int): Matrix
}
