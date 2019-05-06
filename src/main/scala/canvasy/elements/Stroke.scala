package canvasy.elements

import org.scalajs.dom

import canvasy.utils.{Color, LineJoin}


class Stroke() {
  var width: Double = 1.0
  var color: Color = Color.black
  var fillStyle: Color = Color.black
  var lineJoin: LineJoin = LineJoin.default

  def apply(o: Any) {
    o match {
      case i: Int => width = i
      case i: Double => width = i
      case c: Color => color = c
    }
  }


  def adapt_context(context: dom.CanvasRenderingContext2D) {
    context.lineWidth = width
    context.strokeStyle = color.code
    context.fillStyle = fillStyle.code
    context.lineJoin = lineJoin.code
  }
}
