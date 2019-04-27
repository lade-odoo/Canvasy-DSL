package canvasy.modifiers

import canvasy.elements.Shape

import canvasy.utils.Color


case class StrokeColor(c: Color) extends CanvasyElementModifier[Shape] {

  override def change(x: Shape) = { x.stroke.color = c }
}
