package canvasy.elements.shapes

import org.scalajs.dom

import canvasy.elements.properties.{Constructable, Animateable}


class Circle(var radius: Double, var x: Int, var y: Int) extends Shape
      with Constructable with Animateable {

  override def size(size: Int) = {
    radius = size/6.28
  }

  def move(vx: Int, vy: Int) { x += vx; y += vy }
  def is_on_x_border(max_x: Double, vx: Int) = (x + radius + vx > max_x || x + vx - radius < 0)
  def is_on_y_border(max_y: Double, vy: Int) = (y + radius + vy > max_y || y + vy - radius < 0)

  override def draw_shape(context: dom.CanvasRenderingContext2D) {
    context.moveTo(x + radius, y)
    context.arc(x, y, radius, 0, 2*3.14*construction_percentage/100)

    if(!is_constructed()) { super[Constructable].advance_construction }
    else                  { super[Animateable].animate(this, context) }
  }
}
