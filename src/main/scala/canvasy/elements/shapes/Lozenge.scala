package canvasy.elements.shapes

import org.scalajs.dom

import canvasy.elements.Point


class Lozenge(size: Double, x: Int, y: Int) extends Polygon(Array(
        Point(x - (size/2).toInt, y), Point(x, y + (size/2).toInt),
        Point(x + (size/2).toInt, y), Point(x, y - (size/2).toInt)
))
