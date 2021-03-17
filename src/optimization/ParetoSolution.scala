package optimization

import scala.collection.JavaConverters._

object ParetoSolution {
  def main(args: Array[String]): Unit = {
    //Define Pareto Boundary
    println("Please define a proper double value from (0,1) interval for the Data subject:")
    val x = scala.io.StdIn.readDouble()
    println("Please define a proper double value from (0,1) interval for the Data controller:")
    val y = scala.io.StdIn.readDouble()

    val pairs = ObjectiveFunctions.getVertices.asScala.filter(e => e.getX > x && e.getY > y)
    val nonDominateList = Dominance.findNonDominatedVertices(pairs.asJava).asScala
    nonDominateList.foreach(println)
  }

  def join[T](list: List[List[T]]): List[List[T]] =
    list match {
      case xs :: Nil => xs map (List(_))
      case x :: xs => for {
        i <- x
        j <- join(xs)
      } yield List(i) ++ j
    }

  def findAllTC(tc: ThreatControl) = permutationWithRepetition(tc.status.values.toList, tc.controls.size)
    .groupBy(e => e.sum).keys.toList.sorted.map(e => (tc, 1 - (e / tc.controls.size))).filterNot(_._2 == 0)

  def permutationWithRepetition(list: List[Double], size: Int): List[List[Double]] = {
    if (size == 0)
      List(List())
    else {
      for {
        x <- list
        xs <- permutationWithRepetition(list, size - 1)
      } yield x :: xs
    }
  }

  case class ThreatControl(threatName: String, controls: List[String], status: Map[String, Double], rd: Double, rp: Double)

}
