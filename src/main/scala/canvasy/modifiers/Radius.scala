package canvasy.modifiers

import canvasy.elements.Circle


case class Radius(r: Double) extends CanvasyElementModifier[Circle] {

  override def change(x: Circle) = { x.radius = r }
}
