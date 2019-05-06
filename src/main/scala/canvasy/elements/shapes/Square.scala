package canvasy.elements.shapes

import org.scalajs.dom

import canvasy.elements.Point


class Square(size: Double, x: Int, y: Int) extends Polygon(Array(
        Point(x, y), Point(x + size.toInt, y),
        Point(x + size.toInt, y + size.toInt), Point(x, y + size.toInt)
))
