package prv.ramzez.sudoku.solver

/**
  * Created by Ramzez on 2016-12-10.
  */

object Posibility {
  def fromIndex(index: Int): Posibility = {
    new Posibility(index / dim / dim, (index / dim) % dim, index % dim)
  }

  def apply(row: Int, column: Int, value: Int): Posibility = new Posibility(row, column, value)
}

class Posibility(row: Int, column: Int, value: Int) {
  val index = row * dim * dim + column * dim + value;
}
