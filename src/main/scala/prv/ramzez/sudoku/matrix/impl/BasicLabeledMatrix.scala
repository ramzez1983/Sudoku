package prv.ramzez.sudoku.matrix.impl

import prv.ramzez.sudoku.matrix.{LabeledMatrix, Matrix}

/**
  * Created by Ramzez on 2016-12-22.
  */
class BasicLabeledMatrix[L, T](val rowLabels: Seq[L], val matrix: Matrix[T]) extends LabeledMatrix[L, T] {
  override def getRowLabel(r: Int): L = rowLabels(r)

  override def getRow(row: Int): Seq[T] = matrix.getRow(row)

  override def removeRow(row: Int): BasicLabeledMatrix[L, T] =
    new BasicLabeledMatrix[L, T](rowLabels.take(row) ++ rowLabels.drop(row + 1), matrix.removeRow(row))

  override def apply(row: Int, column: Int): T = matrix(row, column)

  override def getColumn(column: Int): Seq[T] = matrix.getColumn(column)

  override def isEmpty: Boolean = matrix.isEmpty

  override def removeColumn(column: Int): BasicLabeledMatrix[L, T] =
    new BasicLabeledMatrix[L, T](rowLabels, matrix.removeColumn(column))

  def canEqual(other: Any): Boolean = other.isInstanceOf[BasicLabeledMatrix[L,T]]

  override def equals(other: Any): Boolean = other match {
    case that: BasicLabeledMatrix[L,T] =>
      (that canEqual this) &&
        rowLabels == that.rowLabels &&
        matrix == that.matrix
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(rowLabels, matrix)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"BasicLabeledMatrix($rowLabels, $matrix)"

  override def columns: Seq[Seq[T]] = matrix.columns

  override def rows: Seq[Seq[T]] = matrix.rows
}
