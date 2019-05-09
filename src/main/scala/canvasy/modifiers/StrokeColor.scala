package canvasy.modifiers

import canvasy.elements.shapes.Shape

import canvasy.utils.Color


case class StrokeColor(c: Color) extends CanvasyElementModifier[Shape] {

  override def change(x: Shape) = { println("changing stroke"); x.stroke.color = c }
}
