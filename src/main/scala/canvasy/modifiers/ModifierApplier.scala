package canvasy.modifiers

import canvasy.elements.shapes.Shape


class ModifierApplier(val elements: Array[Shape]) {

  def and(modif: CanvasyElementModifier[Shape]) = { elements.foreach(_.change(modif)); this }
}

object ModifierApplier {

  def apply(obj: Any) = {
    obj match {
      case element: Shape => new ModifierApplier(Array(element))
      case elements: Array[Shape] => new ModifierApplier(elements)
      case _ => ???
    }
  }
}
