package canvasy.shapes

import org.scalajs.dom


trait Drawable {
  def draw(context: dom.CanvasRenderingContext2D) {
    context.beginPath()

    prepare_pencil(context)
    draw_shape(context)

    context.stroke()
  }

  def prepare_pencil(context: dom.CanvasRenderingContext2D) {}
  def draw_shape(context: dom.CanvasRenderingContext2D) {}
}
