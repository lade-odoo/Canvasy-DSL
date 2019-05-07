package canvasy.modifiers

import canvasy.elements.shapes.Triangle


case class Base(b: Double) extends CanvasyElementModifier[Triangle] {

  override def change(x: Triangle) = { x.base(b) }
}
