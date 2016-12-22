package prv.ramzez.sudoku.matrix.impl

import prv.ramzez.sudoku.matrix.Matrix

/**
  * Created by Ramzez on 2016-12-21.
  */
class ListMatrix[T](private val store: List[List[T]]) extends Matrix[T] {

  override def apply(row: Int, column: Int): T = store(row)(column)

  override def getRow(row: Int): List[T] = store(row)

  override def removeRow(row: Int): Matrix[T] = new ListMatrix(store.take(row):::store.drop(row + 1))

  override def getColumn(column: Int): List[T] = store.map(m => m(column))

  override def isEmpty: Boolean = store.foldLeft(true)((v, l) => v && l.isEmpty)

  override def removeColumn(column: Int): Matrix[T] = new ListMatrix(store.map(m => m.take(column):::m.drop(column + 1)))

  def canEqual(other: Any): Boolean = other.isInstanceOf[ListMatrix[T]]

  override def equals(other: Any): Boolean = other match {
    case that: ListMatrix[T] =>
      (that canEqual this) &&
        store == that.store
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(store)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

