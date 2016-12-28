package prv.ramzez.sudoku.matrix

import prv.ramzez.sudoku.UnitSpec
import prv.ramzez.sudoku.matrix.impl.{BasicLabeledMatrix, ListMatrix}

import scala.collection.immutable.Stream.Empty

/**
  * Created by lukasz.wolanski on 27.12.2016.
  */
class BasicLabeledMatrixSpec extends UnitSpec with MatrixBehaviors {
  def newMatrix(list: Seq[Seq[Int]]): Matrix[Int] = new BasicLabeledMatrix[Int, Int](list match {
    case List(Empty) => List()
    case _ => list.map(m => m.head)
  }, new ListMatrix(list))

  def withLabeledMatrix(testCode: LabeledMatrix[String, Int] => Any): Unit = {
    val m = new BasicLabeledMatrix[String, Int](List("rowOne", "rowTwo", "rowThree"), new ListMatrix[Int](List(rowOne, rowTwo, rowThree)))
    testCode(m)
  }

  "An empty BasicLabeledMatrix" should behave like emptyMatrix(newMatrix(List(List())))

  "A BasicLabeledMatrix" should behave like nonEmptyMatrix(newMatrix)

  it should "return row label" in withLabeledMatrix { (m) =>
    m.getRowLabel(0) should be("rowOne")
    m.getRowLabel(1) should be("rowTwo")
    m.getRowLabel(2) should be("rowThree")
  }

  it should "return row label after removing row" in withLabeledMatrix { (m) =>
    val m1 = m.removeRow(1)
    m1.getRowLabel(0) should be("rowOne")
    m1.getRowLabel(1) should be("rowThree")
  }

  it should "return row by labels" in withLabeledMatrix { (m) =>
    (0 until 3).foreach { (x) =>
      m.getRow(x) shouldEqual (m.getRow(m.getRowLabel(x)))
    }
  }
}
