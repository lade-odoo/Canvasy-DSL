package canvasy.shapes

import org.scalajs.dom


class Rectangle(width: Double, height: Double, var x: Int, var y: Int) extends Shape {

  override def draw_shape(context: dom.CanvasRenderingContext2D) {
    context.moveTo(x, y)
    context.lineTo(x, y + height)
    context.lineTo(x + width, y + height)
    context.lineTo(x + width, y)
    context.lineTo(x, y)
  }
}
