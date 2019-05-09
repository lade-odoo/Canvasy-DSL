package canvasy.modifiers

import canvasy.elements.shapes.Shape


case class StrokeShadowBlur(v: Double) extends CanvasyElementModifier[Shape] {

  override def change(x: Shape) = { x.stroke.shadowBlur = v }
}
