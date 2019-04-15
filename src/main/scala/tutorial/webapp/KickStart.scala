package tutorial.webapp

import canvasy._
import canvasy.elements._

import org.scalajs.dom
import dom.{document, html}


object WebApp {
  def main(args: Array[String]): Unit = {
    val canvas = document.createElement("canvas").asInstanceOf[html.Canvas]
    document.body.appendChild(canvas)

    val w = 300
    canvas.width = w
    canvas.height = w

    dslDemo(canvas)
  }

  def dslDemo(canvas: html.Canvas) = {
    // From now on, we use the DSL
    val canvasy = new Canvasy(canvas) //isn't canvasy a nice name for a library?

    // Let us create some shapes
    val circles = Array.fill(4)(new Circle(50.0, 0, 0))
    val rectangles = Array.tabulate(2)(i => new Rectangle(i*50, i*50, 50, 100))

    // Tell the library to display both circles and rectangles in the canvas
    canvasy += circles
    canvasy += rectangles

    // the first way to edit elements is by modifying their properties directly
    //circles(0) stroke rgb"#ee22aa"
    circles(0) stroke 12
    circles(1) translateY 50

    // let us draw all these things
    canvasy draw()
  }
}
