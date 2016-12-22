package prv.ramzez.sudoku.matrix.impl

import prv.ramzez.sudoku.matrix.{LabeledMatrix, Matrix}

/**
  * Created by Ramzez on 2016-12-22.
  */
class BasicLabeledMatrix[L, T](val labels: Seq[L], val matrix: Matrix[T]) extends LabeledMatrix[L, T] {
  override def getRowLabel(r: Int): L = labels(r)

  override def getRow(row: Int): Seq[T] = matrix.getRow(row)

  override def removeRow(row: Int): BasicLabeledMatrix[L, T] =
    new BasicLabeledMatrix[L, T](labels.take(row) ++ labels.drop(row + 1), matrix.removeRow(row))

  override def apply(row: Int, column: Int): T = matrix(row, column)

  override def getColumn(column: Int): Seq[T] = matrix.getColumn(column)

  override def isEmpty: Boolean = labels.isEmpty

  override def removeColumn(column: Int): BasicLabeledMatrix[L, T] =
    new BasicLabeledMatrix[L, T](labels, matrix.removeColumn(column))
}
