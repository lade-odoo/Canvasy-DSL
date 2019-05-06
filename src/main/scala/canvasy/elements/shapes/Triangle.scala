package canvasy.elements.shapes

import org.scalajs.dom

import canvasy.elements.Point


class Triangle(base: Double, height: Double, x: Int, y: Int) extends Polygon(Array(
        Point(x, y), Point(x + base.toInt, y),
        Point(x + (base/2).toInt, y - height.toInt)
))
