package canvasy.modifiers

import canvasy.elements.shapes.Shape

import canvasy.utils.Color


case class StrokeFillStyle(c: Color) extends CanvasyElementModifier[Shape] {

  override def change(x: Shape) = { x.stroke.fillStyle = c }
}
