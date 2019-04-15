package canvasy.elements

import org.scalajs.dom

import canvasy.utils.Color


class Stroke() {
  var width: Double = 1.0
  var color: Color = Color.black

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
  }
}
