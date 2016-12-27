package prv.ramzez.sudoku.solver

import prv.ramzez.sudoku.UnitSpec
import prv.ramzez.sudoku.matrix.impl.{BasicLabeledMatrix, ListMatrix}

/**
  * Created by Ramzez on 2016-12-21.
  */
class ExactCoverSpec extends UnitSpec with ExactCover {
  "exact cover" should "return solution" in {
    solve(List(), new BasicLabeledMatrix[Int,Int](1 to 7,new ListMatrix(List(
      List(1, 0, 0, 1, 0, 0, 1),//1
      List(1, 0, 0, 1, 0, 0, 0),//2
      List(0, 0, 0, 1, 1, 0, 1),//3
      List(0, 0, 1, 0, 1, 1, 0),//4
      List(0, 1, 1, 0, 0, 1, 1),//5
      List(0, 1, 0, 0, 0, 0, 1) //6
     )))) shouldEqual List(List(2,4,6))
  }
}
