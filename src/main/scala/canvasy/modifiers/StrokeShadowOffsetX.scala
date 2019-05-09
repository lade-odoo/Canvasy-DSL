package canvasy.modifiers

import canvasy.elements.shapes.Shape


case class StrokeShadowOffsetX(v: Double) extends CanvasyElementModifier[Shape] {

  override def change(x: Shape) = { x.stroke.shadowOffsetX = v }
}
