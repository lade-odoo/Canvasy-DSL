package canvasy.utils

import canvasy.elements.{CanvasyElement, Shape}
import canvasy.modifiers.CanvasyElementModifier


object ArrayUtils {
  implicit class CanvasyElementArrayImprovements(elements: Array[_ <: CanvasyElement]) {

    def translateY(delta: Int) = { elements.foreach(_.translateY(delta)); this }
    def translateX(delta: Int) = { elements.foreach(_.translateX(delta)); this }
  }

  implicit class ShapeArrayImprovements(elements: Array[_ <: Shape]) {

    def animate_construction() = { elements.foreach(_.animate_construction()); this }
    def move_randomly(delta: Int = 1) = { elements.foreach(_.move_randomly(delta)); this }
  }
}
