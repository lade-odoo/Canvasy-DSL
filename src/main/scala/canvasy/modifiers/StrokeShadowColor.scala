package canvasy.modifiers

import canvasy.elements.shapes.Shape

import canvasy.utils.Color


case class StrokeShadowColor(c: Color) extends CanvasyElementModifier[Shape] {

  override def change(x: Shape) = { x.stroke.shadowColor = c }
}
