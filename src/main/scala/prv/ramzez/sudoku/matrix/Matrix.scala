package prv.ramzez.sudoku.matrix

/**
  * Created by Ramzez on 2016-12-21.
  */
trait Matrix[T] extends ((Int, Int) => T) {
  def apply(row: Int, column: Int): T

  def isEmpty: Boolean

  def getColumn(column: Int): List[T]

  def removeColumn(column: Int): Matrix[T]

  def getRow(row: Int): List[T]

  def removeRow(row: Int): Matrix[T]
}

trait LabeledMatrix[L, T] extends Matrix[T] {
  def getRowLabel(r: Int): L
}
