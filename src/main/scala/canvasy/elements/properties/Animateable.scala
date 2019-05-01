package canvasy.elements.properties

import canvasy.elements.CanvasyElement


trait Animateable {
  var enabled: Boolean = false


  def enable_animation() = { enabled = true }

  def animate(element: CanvasyElement) = { element.translateRandom(5) }
}
