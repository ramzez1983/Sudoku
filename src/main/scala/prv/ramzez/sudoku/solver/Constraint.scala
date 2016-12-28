package prv.ramzez.sudoku.solver

/**
  * Created by lukasz.wolanski on 28.12.2016.
  */
sealed trait Constraint {

}

case class RowColumn(val row: Int, val column: Int) extends Constraint
case class RowNumber(val row: Int, val value: Int) extends Constraint
case class ColumnNumber(val column: Int, val value: Int) extends Constraint
case class BoxNumber(val box: Int, val value: Int) extends Constraint