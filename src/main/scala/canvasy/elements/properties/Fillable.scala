package canvasy.elements.properties

import org.scalajs.dom


trait Fillable {
  private var enabled: Boolean = false

  def fill() = { enabled = true }

  def apply(context: dom.CanvasRenderingContext2D) {
    if(enabled) { context.fill() }
  }
}
