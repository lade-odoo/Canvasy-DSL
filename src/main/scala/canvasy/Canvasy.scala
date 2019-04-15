package canvasy

import org.scalajs.dom
import dom.html

import scala.Array._
import scala.collection.mutable.ListBuffer

import shapes.Shape


class Canvasy(val canvas: html.Canvas, val shapes: ListBuffer[Shape] = new ListBuffer[Shape]()) {
  val context = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]

  def += (added: Array[_ <: Shape]): Canvasy = {
    shapes ++= added
    this
  }

  def draw() {
    shapes.foreach(_.draw(context))
  }
}
