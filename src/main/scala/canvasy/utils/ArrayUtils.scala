package canvasy.utils

import canvasy.elements.{CanvasyElement, Shape}
import canvasy.modifiers.{CanvasyElementModifier, ModifierApplier}


object ArrayUtils {
  implicit class CanvasyElementArrayImprovements[T <: CanvasyElement](elements: Array[T]) {

    def translateY(delta: Int) = { elements.foreach(_.translateY(delta)); this }
    def translateX(delta: Int) = { elements.foreach(_.translateX(delta)); this }

    def change(modif: CanvasyElementModifier[T]) = { elements.foreach(modif.change(_)); ModifierApplier(elements) }
  }

  implicit class ShapeArrayImprovements[T <: Shape](elements: Array[T]) {

    def animate_construction() = { elements.foreach(_.animate_construction()); this }
    def move_randomly(delta: Int = 1) = { elements.foreach(_.move_randomly(delta)); this }
  }
}
