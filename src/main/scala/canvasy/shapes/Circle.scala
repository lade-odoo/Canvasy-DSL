package canvasy.shapes

import org.scalajs.dom


class Circle(radius: Double, x: Int, y: Int) extends Shape(x, y) {

  def draw(context: dom.CanvasRenderingContext2D) {
    context.arc(x, y, radius, 0, 2*3.14)
  }
}
