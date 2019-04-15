package canvasy.elements

import org.scalajs.dom


class Circle(radius: Double, var x: Int, var y: Int) extends Shape {

  override def draw_shape(context: dom.CanvasRenderingContext2D) {
    context.moveTo(x + radius, y)
    context.arc(x, y, radius, 0, 2*3.14)
  }
}
