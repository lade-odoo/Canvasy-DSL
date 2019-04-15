package canvasy.elements

import org.scalajs.dom


class Stroke() {
  var width: Double = 1.0

  def apply(o: Any) {
    o match {
      case i: Int => width = i
      case i: Double => width = i
    }
  }


  def adapt_context(context: dom.CanvasRenderingContext2D) {
    context.lineWidth = width
  }
}
