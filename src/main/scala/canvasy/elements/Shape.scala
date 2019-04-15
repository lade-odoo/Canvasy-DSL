package canvasy.elements

import org.scalajs.dom


trait Shape extends CanvasyElement {
  val stroke: Stroke = new Stroke()

  final override def draw(context: dom.CanvasRenderingContext2D) {
    context.beginPath()

    stroke.adapt_context(context)
    draw_shape(context)

    context.stroke()
  }

  def draw_shape(context: dom.CanvasRenderingContext2D)
}
