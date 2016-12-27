package prv.ramzez.sudoku.solver

import prv.ramzez.sudoku.matrix.{LabeledMatrix, Matrix}

/**
  * Created by Ramzez on 2016-12-10.
  */
trait ExactCover {

  //TODO: implement
  private def chooseColumn(matrix: Matrix[Int]): List[Int] = ???

  /**
    * Step 5. Reduce matrix
    * For each column j such that A(r, j) = 1,
    *   for each row i such that A(i, j) = 1,
    *     delete row i from matrix A.
    *   delete column j from matrix A.
    *
    * @param matrix
    * @param row
    * @return
    */
  private def reduceMatrix(matrix: LabeledMatrix[Int,Int], row: Int): LabeledMatrix[Int,Int] = {
    val columns2Remove: IndexedSeq[Int] = getIndexesOf1(matrix.getRow(row))
    val rows2Remove: Set[Int] = columns2Remove.flatMap(c => getIndexesOf1(matrix.getColumn(c))).toSet
    val m1: LabeledMatrix[Int,Int] = rows2Remove.foldLeft(matrix)((m, i) => m.removeRow(i))
    columns2Remove.foldLeft(m1)((m, j) => m.removeColumn(j))
  }

  /**
    * Algorithm X implementation
    *
    * @param currentSolution
    * @param matrix
    * @return
    */
  def solve(currentSolution: Solution, matrix: LabeledMatrix[Int,Int]): List[Solution] = {
    //Step 1. If the matrix A has no columns, the current partial solution is a valid solution; terminate successfully.
    if (matrix.isEmpty) List(currentSolution)
    else {
      //Step 2. Otherwise choose a column c (deterministically).
      val col = chooseColumn(matrix)
      //Step 3. Choose a row r such that Ar, c = 1 (nondeterministically).
      val rows = getIndexesOf1(col)
      //Step 4. Include row r in the partial solution.
      //Step 5. Reduce matrix
      //Step 6. Repeat this algorithm recursively on the reduced matrix.
      rows.flatMap(r => solve(matrix.getRowLabel(r) :: currentSolution, reduceMatrix(matrix, r))).filterNot(_.isEmpty).toList
    }
  }

  private def getIndexesOf1(col: Seq[Int]): IndexedSeq[Int] = {
    (col.length - 1 to 0).filter(col(_) != 0)
  }
}
