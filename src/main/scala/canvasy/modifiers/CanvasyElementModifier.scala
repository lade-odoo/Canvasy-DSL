package canvasy.modifiers

import canvasy.elements.CanvasyElement


trait CanvasyElementModifier[-ApplyOn <: CanvasyElement] {

  def change(x: ApplyOn): Unit
}
