package canvasy.utils

import canvasy.elements.CanvasyElement
import canvasy.modifiers.{CanvasyElementModifier, ModifierApplier}
import canvasy.elements.properties.{Constructable, Animateable, Fillable, Selectable}


object ArrayUtils {
  implicit class CanvasyElementArrayImprovements[T <: CanvasyElement](elements: Array[T]) {

    def translateY(delta: Int) = { elements.foreach(_.translateY(delta)); this }
    def translateX(delta: Int) = { elements.foreach(_.translateX(delta)); this }

    def change(modif: CanvasyElementModifier[T]) = { elements.foreach(modif.change(_)); ModifierApplier(elements) }
  }

  implicit class ConstructableArray[T <: Constructable](elements: Array[T]) {
    def animate_construction() = { elements.foreach(_.animate_construction()); this }
  }

  implicit class AnimateableArray[T <: Animateable](elements: Array[T]) {
    def animate() = { elements.foreach(_.enable_animation()); this }
  }

  implicit class FillableArray[T <: Fillable](elements: Array[T]) {
    def fill() = { elements.foreach(_.fill()); this }
  }

  implicit class SelectableArray[T <: Selectable](elements: Array[T]) {
    def selectable() = { elements.foreach(_.selectable()); this }
  }
}
