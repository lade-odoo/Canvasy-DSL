package canvasy.modifiers

import canvasy.elements.Rectangle


case class Width(w: Double) extends CanvasyElementModifier[Rectangle] {

  override def change(x: Rectangle) = { x.width = w }
}
