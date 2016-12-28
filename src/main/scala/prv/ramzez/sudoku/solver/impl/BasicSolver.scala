package prv.ramzez.sudoku.solver.impl

import prv.ramzez.sudoku.model._
import prv.ramzez.sudoku.solver.{ExactCover, Posibility}

import scala.io.Source

/**
  * Created by Ramzez on 2016-12-21.
  */
object BasicSolver extends ExactCover[Posibility,Int] with App {

  override val unit: Int = 1

  val dim = 3

  def readFile(filePath: String): Source = ???

  def parseToPosibility: String => Posibility = ???

  val initialMatrix = ???
  args match {
    case Array(filePath: String) => {
      val startPosition = readFile(filePath).getLines.map(parseToPosibility).toSet
      val solutions = solve(startPosition,startPosition.foldLeft(initialMatrix)(reduceMatrix))
      solutions.map(s => s.foldLeft[Board](EmptyBoard(dim))((b, p) => b ++ p)).foreach(b => System.out.println(b.mkString(" ","\n")))
    }
    case _ => throw new IllegalArgumentException("provide exactly one argument: path to input file")
  }
}
