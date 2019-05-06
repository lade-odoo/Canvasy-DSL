package canvasy.elements


case class Point(x: Int, y: Int) {
  def distance_from(other: Point): Double = {
    val xx = this.x - other.x; val yy = this.y - other.y

    scala.math.sqrt(xx*xx+yy*yy)
  }
}
