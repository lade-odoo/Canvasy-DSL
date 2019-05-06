package canvasy.elements.shapes

import org.scalajs.dom

import canvasy.properties._


class Circle(var radius: Double, var x: Int, var y: Int) extends Shape {

  override def size(size: Int) = {}

  def adapt_position(mouse_x: Int, mouse_y: Int, offset_x: Int, offset_y: Int) {
    x = mouse_x + offset_x
    y = mouse_y + offset_y
  }

  override def move(vx: Int, vy: Int) { x += vx; y += vy }
  override def is_on_x_border(max_x: Double, vx: Int) = (x + radius + vx > max_x || x + vx - radius < 0)
  override def is_on_y_border(max_y: Double, vy: Int) = (y + radius + vy > max_y || y + vy - radius < 0)

  override def is_selected(mouse_x: Double, mouse_y: Double) = {
    val xx = x - mouse_x; val yy = y - mouse_y
    val dist_from_center = scala.math.sqrt(xx*xx+yy*yy)

    super[Shape].is_selected(mouse_x, mouse_y) && dist_from_center <= radius + stroke.width/2
  }

  override def draw_shape(context: dom.CanvasRenderingContext2D) {
    context.moveTo(x + radius, y)
    context.arc(x, y, radius, 0, 2*3.14*construction_percentage/100)

    if(!is_constructed())     { super[Shape].advance_construction }
    else if(is_animatable())  { super[Shape].animate(this, context) }
  }
}
