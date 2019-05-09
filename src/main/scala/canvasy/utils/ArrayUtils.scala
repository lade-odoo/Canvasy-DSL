package canvasy.utils

import org.scalajs.dom

import canvasy.elements.CanvasyElement
import canvasy.modifiers.{CanvasyElementModifier, ModifierApplier}
import canvasy.properties._


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

    def animate(animation: (Animateable, dom.CanvasRenderingContext2D, Int, Int) => (Int, Int)) = {
      elements.foreach(_.enable_animation(animation)); this
    }
  }

  implicit class FillableArray[T <: Fillable](elements: Array[T]) {
    def fill() = { elements.foreach(_.fill()); this }
  }

  implicit class DashedArray[T <: Dashed](elements: Array[T]) {
    def dash() = { elements.foreach(_.dash()); this }
  }

  implicit class SelectableArray[T <: Selectable](elements: Array[T]) {
    def selectable() = { elements.foreach(_.selectable()); this }
  }
}
