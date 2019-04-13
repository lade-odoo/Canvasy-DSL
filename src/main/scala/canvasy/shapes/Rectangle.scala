package canvasy.shapes

import org.scalajs.dom


class Rectangle(width: Double, height: Double, x: Int, y: Int) extends Shape(x, y) {

  def draw(context: dom.CanvasRenderingContext2D) {
    context.moveTo(x, y)
    context.lineTo(x, y + height)
    context.lineTo(x + width, y + height)
    context.lineTo(x + width, y)
    context.lineTo(x, y)
  }
}
