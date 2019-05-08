package canvasy.properties

import org.scalajs.dom


trait Fillable {
  private var enabled: Boolean = false

  def fill() { enabled = true }

  def is_filled() = enabled

  def apply(context: dom.CanvasRenderingContext2D) {
    if(enabled) { context.closePath(); context.fill() }
  }
}
