package tutorial.webapp

import canvasy._
import canvasy.elements._
import canvasy.utils.ArrayUtils._
import canvasy.utils.Color._

import org.scalajs.dom
import dom.{document, html}


object WebApp {
  def main(args: Array[String]): Unit = {
    val canvas = document.createElement("canvas").asInstanceOf[html.Canvas]
    document.body.appendChild(canvas)

    val w = 300
    canvas.width = w
    canvas.height = w

    // dslDemo(canvas)
    dsl(canvas)
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
    circles(0) stroke rgb"#ee22aa"
    circles(0) stroke 12
    circles(1) translateY 50

    // array/list/iterables... of elements form Groups. Groups have a position, and can be translated.
    // this translates all the elements inside the group.
    circles translateX 100 translateY 100

    // easily create a group with the keyword "and"
    circles(2) and circles(3) translateX 50

    circles(2) translateX 22

    // let us draw all these things
    canvasy draw()
  }

  def dsl(canvas: html.Canvas) = {
    val canvasy = new Canvasy(canvas)
    val circles = Array.fill(4)(new Circle(50.0, 0, 0))
    val rectangles = Array.tabulate(2)(i => new Rectangle(i*50, i*50, 50, 100))

    canvasy += circles
    canvasy += rectangles

    circles(0) stroke rgb"#ee22aa"
    circles(0) stroke 12
    circles(1) translateY 50
    circles(2) translateX 22

    circles(2) and circles(3) translateX 50
    circles translateX 100 translateY 100

    circles animate_construction()
    circles move_randomly(10)

    canvasy draw()
  }
}
