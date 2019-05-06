package canvasy.elements.shapes

import org.scalajs.dom

import canvasy.elements.Point


class Rectangle(var width: Double, var height: Double, x: Int, y: Int) extends Polygon(Array(
        Point(x, y), Point(x, y + height.toInt),
        Point(x + width.toInt, y + height.toInt), Point(x + width.toInt, y)
)) {

  def width(w: Double) {
    this.width = w
    super.set_points(Array(Point(x, y), Point(x, y + height.toInt),
                    Point(x + width.toInt, y + height.toInt), Point(x + width.toInt, y)))
  }

  def height(h: Double) {
    this.height = h
    super.set_points(Array(Point(x, y), Point(x, y + height.toInt),
                    Point(x + width.toInt, y + height.toInt), Point(x + width.toInt, y)))
  }
}
