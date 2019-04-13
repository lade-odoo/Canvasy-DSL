package canvasy.shapes

import org.scalajs.dom


abstract class Shape(var x: Int, var y: Int) {
  
  // Abstract method
  def draw(context: dom.CanvasRenderingContext2D)
}
