package canvasy.modifiers

import canvasy.elements.shapes.Shape


case class StrokeShadowOffsetY(v: Double) extends CanvasyElementModifier[Shape] {

  override def change(x: Shape) = { x.stroke.shadowOffsetY = v }
}
