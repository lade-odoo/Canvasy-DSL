package canvasy.properties

import org.scalajs.dom


trait Animateable {
  private val random = scala.util.Random
  private var enabled: Boolean = false
  private var vx: Int = random.nextInt(10)
  private var vy: Int = random.nextInt(10)


  def enable_animation() = { enabled = true }
  def is_animatable() = enabled

  def move(vx: Int, vy: Int)
  def is_on_x_border(max_x: Double, vx: Int): Boolean
  def is_on_y_border(max_y: Double, vy: Int): Boolean

  def animate(element: Animateable, context: dom.CanvasRenderingContext2D) {
    val frame_rect = context.canvas.getBoundingClientRect()
    element.move(vx, vy)

    if(element.is_on_x_border(frame_rect.width, vx)) { vx = -vx }
    if(element.is_on_y_border(frame_rect.height, vy)) { vy = -vy }
  }
}
