package canvasy.elements.shapes

import org.scalajs.dom

import canvasy.elements.properties.{Constructable, Animateable}


class Rectangle(var width: Double, var height: Double, var x: Int, var y: Int) extends Shape
            with Constructable with Animateable {

  override def size(size: Int) = {
    width = (size - 2*height)/2
  }

  override def draw_shape(context: dom.CanvasRenderingContext2D): Unit = {
    var perimeter = 2 * (height + width) * construction_percentage/100
    if(!is_constructed()) { super[Constructable].advance_construction }
    else                  { super[Animateable].animate(this) }

    context.moveTo(x, y)
    perimeter -= height
    if(perimeter >= 0)  { context.lineTo(x, y + height) }
    else                { context.lineTo(x, y + perimeter + height); return }

    context.moveTo(x, y + height)
    perimeter -= width
    if(perimeter >= 0)  { context.lineTo(x + width, y + height) }
    else                { context.lineTo(x + perimeter + width, y + height); return }

    context.moveTo(x + width, y + height)
    perimeter -= height
    if(perimeter >= 0)  { context.lineTo(x + width, y) }
    else                { context.lineTo(x + width, y - perimeter); return }

    context.moveTo(x + width, y)
    perimeter -= width
    if(perimeter >= 0)  { context.lineTo(x, y ) }
    else                { context.lineTo(x - perimeter, y); return }
  }
}
