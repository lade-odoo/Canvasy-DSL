package canvasy.elements

import org.scalajs.dom


trait CanvasyElement {
  var x: Int
  var y: Int


  def translateY(delta: Int) { y += delta }
  def translateX(delta: Int) { x += delta }


  def and(other: CanvasyElement) = Array(this, other)


  def draw(context: dom.CanvasRenderingContext2D)
}
