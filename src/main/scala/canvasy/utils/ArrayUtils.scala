package canvasy.utils

import canvasy.elements.CanvasyElement


object ArrayUtils {
  implicit class ArrayImprovements(elements: Array[_ <: CanvasyElement]) {

    def translateY(delta: Int) = { elements.foreach(_.translateY(delta)); this }
    def translateX(delta: Int) = { elements.foreach(_.translateX(delta)); this }
  }
}
