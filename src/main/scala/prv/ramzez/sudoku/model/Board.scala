package prv.ramzez.sudoku.model

import prv.ramzez.sudoku.solver.Posibility

/**
  * Created by lukasz.wolanski on 28.12.2016.
  */
sealed trait Board extends ((Int, Int) => Option[Int]) {
  def dim: Int

  def isIndexOk(d: Int) = if (d >= 0 || d < dim) true else false

  override def apply(row: Int, column: Int): Option[Int] = this match {
    case EmptyBoard(_) => None
    case BoardState(dim, board) => {
      if (isIndexOk(row) || isIndexOk(column)) board(row)(column)
      else throw new IndexOutOfBoundsException(s"Index must be between 0 and $dim")
    }
  }

  def ++(p: Posibility): Board = ???

  def update(row: Int, column: Int, value: Int): Board = ???

  def mkString(s: String, nl: String): String = this match {
    case EmptyBoard(dim) => s"EmptyBoard of dim $dim"
    case BoardState(_, board) => board.map(row => row.map{
      case None => " "
      case Some(v) => v.toString
    }.mkString(s)).mkString(nl)
  }
}
case class EmptyBoard(val dim: Int) extends Board
case class BoardState(val dim: Int, val board: Seq[Seq[Option[Int]]]) extends Board

