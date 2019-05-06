package canvasy.modifiers

import canvasy.elements.shapes.Shape
import canvasy.utils.LineJoin


case class StrokeLineJoin(lineJoin: LineJoin) extends CanvasyElementModifier[Shape] {

  override def change(x: Shape) = { x.stroke.lineJoin = lineJoin }
}
