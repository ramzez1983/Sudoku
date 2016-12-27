package prv.ramzez.sudoku.solver

import prv.ramzez.sudoku.UnitSpec
import prv.ramzez.sudoku.matrix.LabeledMatrix
import prv.ramzez.sudoku.matrix.impl.{BasicLabeledMatrix, ListMatrix}

/**
  * Created by Ramzez on 2016-12-21.
  */
class ExactCoverSpec extends UnitSpec with ExactCover {
  def withSmallMatrix(testCode: LabeledMatrix[Int, Int] => Any) {
    val matrix = new BasicLabeledMatrix[Int, Int](1 to 4, new ListMatrix(List(
      List(1, 0, 0), //1
      List(1, 0, 1), //2
      List(0, 1, 0), //3
      List(0, 0, 1)  //4
    )))
    testCode(matrix)
  }
  def withMediumMatrix(testCode: LabeledMatrix[Int, Int] => Any) {
    val matrix = new BasicLabeledMatrix[Int, Int](1 to 7, new ListMatrix(List(
      List(1, 0, 0, 1, 0, 0, 1), //1
      List(1, 0, 0, 1, 0, 0, 0), //2
      List(0, 0, 0, 1, 1, 0, 1), //3
      List(0, 0, 1, 0, 1, 1, 0), //4
      List(0, 1, 0, 0, 0, 1, 1), //5
      List(0, 1, 0, 0, 0, 0, 1) //6
    )))
    testCode(matrix)
  }

  "choose column" should "return column with min number of ones" in withMediumMatrix { (matrix) =>
    chooseColumn(matrix) shouldEqual List(0,0,0,1,0,0)
  }

  "exact cover" should "return solution" in withMediumMatrix { (matrix) =>
    solve(Set(), matrix) shouldEqual Set(Set(2, 4, 6))
  }

  it should "return all solutions" in withSmallMatrix { (matrix) =>
    solve(Set(), matrix) shouldEqual Set(Set(1, 3, 4), Set(2,3))
  }
}
