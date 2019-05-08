package canvasy.elements.shapes

import org.scalajs.dom

import canvasy.utils.{Color, PolygonUtils}
import canvasy.elements.Point
import canvasy.modifiers.{CanvasyElementModifier, ModifierApplier}
import canvasy.properties.{Constructable, Animateable, Selectable}


class Polygon(var points: Seq[Point]) extends Shape {
  var x = points(0).x
  var y = points(0).y


  def apply(i: Int) = { points(i) }

  def set_points(points: Seq[Point]) { this.points = points }


  final def size(size: Int) {}


  final override def move(vx: Int, vy: Int) {
    points = points.map(p => Point(p.x + vx, p.y + vy))
  }
  final override def is_on_x_border(max_x: Double, vx: Int): Boolean = {
    points.exists(p => (p.x + vx > max_x || p.x + vx < 0))
  }
  final override def is_on_y_border(max_y: Double, vy: Int): Boolean = {
    points.exists(p => (p.y + vy > max_y || p.y + vy < 0))
  }

  // Applying algo: https://www.geeksforgeeks.org/how-to-check-if-a-given-point-lies-inside-a-polygon/
  override def is_selected(mouse_x: Double, mouse_y: Double): Boolean = {
    return super[Shape].is_selected(mouse_x, mouse_y) &&
        PolygonUtils.isInside(this, points.length, Point(mouse_x.toInt, mouse_y.toInt))
  }

  override def adapt_position(mouse_x: Int, mouse_y: Int, offset_x: Int, offset_y: Int) {
    val xx = mouse_x + offset_x; val yy = mouse_y + offset_y
    points = points.map(p => Point(xx + p.x - x, yy + p.y - y))
    x = xx; y = yy
  }


  final def draw_shape(context: dom.CanvasRenderingContext2D): Unit = {
    var perimeter = this.perimeter() * construction_percentage / 100
    context.moveTo(points(0).x, points(0).y)

    for(i <- 0 to (points.length - 1)) {
      val next = (i + 1) % points.length
      val segment_length = points(i).distance_from(points(next))

      if(perimeter >= segment_length) {
        context.lineTo(points(next).x, points(next).y)
        perimeter = perimeter - segment_length
      } else {
        val prop = perimeter/segment_length
        val xx = (points(next).x - points(i).x) * prop
        val yy = (points(next).y - points(i).y) * prop
        context.lineTo(points(i).x + xx, points(i).y + yy)
        return
      }
    }
  }


  final def perimeter() = {
    var sum: Double = 0.0
    for(i <- 0 to (points.length - 1)) {
      sum = sum + points(i).distance_from(points((i+1)%points.length))
    }
    sum
  }
}
