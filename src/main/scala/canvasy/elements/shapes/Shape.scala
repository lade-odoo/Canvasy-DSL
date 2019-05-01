package canvasy.elements.shapes

import org.scalajs.dom

import canvasy.utils.Color
import canvasy.elements.{CanvasyElement, Stroke}
import canvasy.modifiers.{CanvasyElementModifier, ModifierApplier}


trait Shape extends CanvasyElement {
  val stroke: Stroke = new Stroke()


  // change should return the modifier to enable and
  final def change(modif: CanvasyElementModifier[this.type]) = { modif.change(this); ModifierApplier(this) }


  final override def draw(context: dom.CanvasRenderingContext2D) {
    context.beginPath()
    stroke.adapt_context(context)

    draw_shape(context)

    context.stroke()
  }

  def draw_shape(context: dom.CanvasRenderingContext2D)
}
