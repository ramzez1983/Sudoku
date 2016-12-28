package prv.ramzez.sudoku.solver.impl

import prv.ramzez.sudoku.model._
import prv.ramzez.sudoku.solver.{ExactCover, Posibility}

import scala.io.Source

/**
  * Created by Ramzez on 2016-12-21.
  */
object BasicSolver extends ExactCover[Posibility,Int] with App {

  override val unit: Int = 1

  def readFile(filePath: String): Source = ???

  def parseToPosibility: String => Posibility = ???

  val initialMatrix = ???
  //TODO: parametrise ExactCover
/*
  args match {
    case Array(filePath: String) => {
      val startPosition = readFile(filePath).getLines.map(parseToPosibility)
      solve(startPosition,startPosition.foldLeft(initialMatrix)(reduceMatrix))
        //.foldLeft[Board](EmptyBoard(3))((b, p) => b ++ p)

    }
    case _ => throw new IllegalArgumentException("provide exactly one argument: path to input file")
  }
*/

}
