package prv.ramzez.sudoku.solver

import prv.ramzez.sudoku.UnitSpec
import prv.ramzez.sudoku.matrix.impl.ListMatrix

/**
  * Created by Ramzez on 2016-12-21.
  */
class ExactCoverSpec extends UnitSpec with ExactCover {
  "exact cover" should "return solution" in {
    solve(List(), new ListMatrix(List(
      List(1, 0, 0, 1, 0, 0, 1),
      List(1, 0, 0, 1, 0, 0, 0),
      List(0, 0, 0, 1, 1, 0, 1),
      List(0, 0, 1, 0, 1, 1, 0),
      List(0, 1, 1, 0, 0, 1, 1),
      List(0, 1, 0, 0, 0, 0, 1)))) shouldEqual List(2,4,6)
  }
}
