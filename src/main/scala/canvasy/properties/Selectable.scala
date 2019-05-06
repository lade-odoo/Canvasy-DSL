package canvasy.properties

import org.scalajs.dom

import canvasy.Canvasy


trait Selectable {
  private var enabled:Boolean = false

  def is_selected(mouse_x: Double, mouse_y: Double): Boolean = enabled

  def selectable() { enabled = true }

  def adapt_position(mouse_x: Int, mouse_y: Int, offset_x: Int, offset_y: Int)
}
