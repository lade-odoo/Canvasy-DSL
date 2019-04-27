package canvasy.elements

import org.scalajs.dom


class Circle(var radius: Double, var x: Int, var y: Int) extends Shape {

  override def size(size: Int) = {
    radius = size/6.28
  }

  override def draw_shape(context: dom.CanvasRenderingContext2D,  percentage: Int) {
    context.moveTo(x + radius, y)
    context.arc(x, y, radius, 0, 2*3.14*percentage/100)
  }
}
