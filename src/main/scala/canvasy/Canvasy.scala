package canvasy

import org.scalajs.dom
import dom.html

import scala.Array._
import scala.collection.mutable.ListBuffer

import elements.CanvasyElement
import properties.Selectable


class Canvasy(val canvas: html.Canvas) {
  private val elements: ListBuffer[CanvasyElement] = new ListBuffer[CanvasyElement]()
  private val context = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
  private var selected_element: Option[Selectable] = None
  private var selection_offset_x: Double = 0
  private var selection_offset_y: Double = 0

  def += (added: Array[_ <: CanvasyElement]) = { elements ++= added; this }

  def draw() {
    context.clearRect(0, 0, canvas.width, canvas.height)
    elements.foreach(_.draw(context))

    dom.window.requestAnimationFrame((x: Double) => draw())
  }



  // Drag and drop part
  canvas.draggable = true

  canvas.ondragstart = { (evt: dom.DragEvent) =>
    if(selected_element == None) {
      val rect = canvas.getBoundingClientRect()
      val mouse_x = evt.clientX - rect.left
      val mouse_y = evt.clientY - rect.top

      selected_element = find_selected_element(mouse_x, mouse_y)
      selected_element match {
        case Some(element: CanvasyElement) =>
            selection_offset_x = element.x - mouse_x
            selection_offset_y = element.y - mouse_y
        case _ =>
      }
    }
  }

  canvas.ondragend = { (evt: dom.DragEvent) =>
    selected_element = None
  }

  canvas.ondragover = { (evt: dom.DragEvent) =>
    val rect = canvas.getBoundingClientRect()
    val mouse_x = evt.clientX - rect.left
    val mouse_y = evt.clientY - rect.top

    selected_element match {
      case Some(element) => element.adapt_position(mouse_x.toInt, mouse_y.toInt,
                                    selection_offset_x.toInt, selection_offset_y.toInt)
      case None =>
    }
  }

  def find_selected_element(mouse_x: Double, mouse_y: Double): Option[Selectable] = {
    for(element <- elements) {
      element match {
        case s: Selectable if s.is_selected(mouse_x, mouse_y) => return Some(s)
        case _ =>
      }
    }
    return None
  }
}
