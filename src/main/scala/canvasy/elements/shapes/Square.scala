package canvasy.elements.shapes

import org.scalajs.dom

import canvasy.elements.Point


class Square(var size: Double, x: Int, y: Int) extends Rectangle(size, size, x, y) {

  override def width(w: Double) {
    this.size = w
    super.set_points(Array(
            Point(x, y), Point(x + size.toInt, y),
            Point(x + size.toInt, y + size.toInt), Point(x, y + size.toInt)
    ))
  }

  override def height(h: Double) {
    this.size = h
    super.set_points(Array(
            Point(x, y), Point(x + size.toInt, y),
            Point(x + size.toInt, y + size.toInt), Point(x, y + size.toInt)
    ))
  }
}
