package canvasy.properties

import org.scalajs.dom
import scala.scalajs.js


trait Dashed {
  private var enabled: Boolean = false

  def dash() { enabled = true }

  def is_dashed() = enabled

  def apply_dash(context: dom.CanvasRenderingContext2D) {
    if(enabled) { context.setLineDash(js.Array(5.0, 15.0)) }
    else        { context.setLineDash(js.Array()) }
  }
}
