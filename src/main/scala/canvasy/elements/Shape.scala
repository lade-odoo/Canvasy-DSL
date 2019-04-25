package canvasy.elements

import org.scalajs.dom

import canvasy.utils.Color


trait Shape extends CanvasyElement {
  val stroke: Stroke = new Stroke()

  var is_dynamic_construction: Boolean = false
  var construction_percentage: Int = 0

  var is_moving_randomly: Boolean = false
  var random_step: Int = 1


  final override def draw(context: dom.CanvasRenderingContext2D) {
    context.beginPath()
    stroke.adapt_context(context)

    if(is_dynamic_construction && construction_percentage <= 100) {
      draw_shape(context, construction_percentage)
      construction_percentage += 1
    } else if(is_moving_randomly) {
      this.translateRandom(random_step)
      draw_shape(context, 100)
    } else {
      draw_shape(context, 100)
    }

    context.stroke()
  }

  def draw_shape(context: dom.CanvasRenderingContext2D, percentage: Int)


  final def animate_construction() = { is_dynamic_construction = true }
  final def move_randomly(delta: Int = 1) = { is_moving_randomly = true; random_step = delta }
}
