package canvasy.elements.shapes

import org.scalajs.dom

import canvasy.elements.Point


class Triangle(var base: Double, var height: Double, x: Int, y: Int) extends Polygon(Array(
        Point(x, y), Point(x + base.toInt, y),
        Point(x + (base/2).toInt, y - height.toInt)
)) {

  def base(b: Double) {
    this.base = b
    super.set_points(Array(
            Point(x, y), Point(x + base.toInt, y),
            Point(x + (base/2).toInt, y - height.toInt)
    ))
  }
}
