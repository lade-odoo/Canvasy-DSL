package canvasy.elements

import scala.util.Random

import org.scalajs.dom


trait CanvasyElement {
  var x: Int
  var y: Int


  def translateY(delta: Int) { y += delta }
  def translateX(delta: Int) { x += delta }
  def translateRandom(delta: Int) {
    val r = Random.nextInt(4)
    r match {
      case 0 => translateX(delta)
      case 1 => translateY(delta)
      case 2 => translateX(-delta)
      case 3 => translateY(-delta)
    }
  }

  // Set the perimeter of the element
  def size(size: Int)


  def and(other: CanvasyElement) = Array(this, other)


  def draw(context: dom.CanvasRenderingContext2D)
}
