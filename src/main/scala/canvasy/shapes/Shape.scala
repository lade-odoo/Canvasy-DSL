package canvasy.shapes

import org.scalajs.dom


trait Shape extends Drawable {
  var x: Int
  var y: Int


  def translateY(delta: Int) { y += delta }
  def translateX(delta: Int) { x += delta }
}
