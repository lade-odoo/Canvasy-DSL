package canvasy.properties

import org.scalajs.dom

import canvasy.elements.shapes.Shape
import canvasy.modifiers.{StrokeColor, StrokeFillStyle}
import canvasy.utils.Color


trait Animateable {
  private val random = scala.util.Random
  private var enabled: Boolean = false
  private var vx: Int = random.nextInt(10)
  private var vy: Int = random.nextInt(10)
  private var animation: (Animateable, dom.CanvasRenderingContext2D, Int, Int) => (Int, Int) = Animateable.default_animation


  def enable_animation() = { enabled = true }
  def enable_animation(animation: (Animateable, dom.CanvasRenderingContext2D, Int, Int) => (Int, Int)) = {
    enabled = true
    this.animation = animation
  }
  def is_animatable() = enabled

  def move(vx: Int, vy: Int)
  def is_on_x_border(max_x: Double, vx: Int): Boolean
  def is_on_y_border(max_y: Double, vy: Int): Boolean

  def animate(element: Animateable, context: dom.CanvasRenderingContext2D): Unit = {
    val (vxx, vyy) = this.animation(element, context, vx, vy)
    vx = vxx; vy = vyy
  }
}


object Animateable {

  def default_animation(element: Animateable, context: dom.CanvasRenderingContext2D, vx: Int, vy: Int): (Int, Int) = {
    val frame_rect = context.canvas.getBoundingClientRect()
    element.move(vx, vy)

    var vxx: Int = vx; var vyy: Int = vy
    if(element.is_on_x_border(frame_rect.width, vx)) { vxx = -vx }
    if(element.is_on_y_border(frame_rect.height, vy)) { vyy = -vy }

    return (vxx, vyy)
  }

  def rainbow_animation(element: Animateable, context: dom.CanvasRenderingContext2D, vx: Int, vy: Int): (Int, Int) = {
    val (vxx, vyy) = default_animation(element, context, vx, vy)

    if(vxx != vx || vyy != vy) {
      element match {
        case e: Shape =>
            println("new color")
            val color: Color = Color.random
            e change StrokeColor(color) and StrokeFillStyle(color)
        case _ =>
      }
    }

    return (vxx, vyy)
  }
}
