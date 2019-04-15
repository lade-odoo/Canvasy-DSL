package canvasy.modifiers

import canvasy.elements.Shape


case class StrokeWidth(w: Double) extends CanvasyElementModifier[Shape] {

  override def change(x: Shape): Unit = {x.stroke.width = w}
}
