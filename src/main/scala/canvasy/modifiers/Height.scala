package canvasy.modifiers

import canvasy.elements.shapes.Rectangle


case class Height(w: Double) extends CanvasyElementModifier[Rectangle] {

  override def change(x: Rectangle) = { x.height(w) }
}
