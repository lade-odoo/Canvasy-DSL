package tutorial.webapp

import canvasy._
import canvasy.utils._
import canvasy.elements._
import canvasy.modifiers._
import canvasy.elements.shapes._
import canvasy.utils.ArrayUtils._
import canvasy.utils.Color._

import org.scalajs.dom
import dom.{document, html}
import org.scalajs.dom.raw.MouseEvent


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

    // of course, groups have foreach/map/flatmap clin d’œil
    (circles(0) and circles(1)).foreach(_.size(30))

    // to modify multiple elements at the same time on their inner properties, we use the "change" notation:
    circles change Radius(10)
    circles(0) change Radius(20) and StrokeColor(Color.red)

    // this should not compile, as a circle has no width:
    // circles change Width(10)

    // however, this should
    rectangles change Width(90)

    // Width, Radius,  StrokeColor and their friend are **not** functions. They are case classes, in order
    // to allow the end user of the library to create new modifiers. All these modifiers inherits from the following
    // trait:

    // trait CanvasyElementModifier[ApplyOn <: CanvasyElement] {
    //   def change(x: ApplyOn): Unit
    // }

    // Let us create an example
    case class StrokeWidth(w: Double) extends CanvasyElementModifier[Shape] {
      // every Shape has a stroke.
      override def change(x: Shape): Unit = x.stroke.width = w
    }
    rectangles change StrokeWidth(3) and StrokeColor(rgb"#aa00e1")
    circles change StrokeWidth(2)

    //Another thing that should work is
    (rectangles ++ circles) change StrokeColor(Color.red)

    //But of course, this should not (circles have no width, but rather have a radius)
    // (rectangles ++ circles) change Width(10)

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

    // circles animate_construction()
    // circles move_randomly(3)

    canvasy draw()

    // canvas.onclick = { (evt: dom.MouseEvent) =>
    //   val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
    //   val rect = canvas.getBoundingClientRect()
    //   val x = evt.clientX - rect.left
    //   val y = evt.clientY - rect.top
    //   println(x)
    //   println(y)
    // }
  }
}
