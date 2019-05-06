package canvasy.elements.shapes

import org.scalajs.dom

import canvasy.elements.{CanvasyElement, Stroke}
import canvasy.modifiers.{CanvasyElementModifier, ModifierApplier}
import canvasy.properties._


abstract class Shape extends CanvasyElement
      with Constructable with Animateable with Selectable with Fillable {
  val stroke: Stroke = new Stroke()


  // change should return the modifier to enable and
  final def change(modif: CanvasyElementModifier[this.type]) = { modif.change(this); ModifierApplier(this) }


  final override def draw(context: dom.CanvasRenderingContext2D) {
    context.beginPath()
    stroke.adapt_context(context)

    draw_shape(context)
    super[Fillable].apply(context)

    if(!super[Constructable].is_constructed())  { super[Constructable].advance_construction() }
    else if(super[Animateable].is_animatable()) { super[Animateable].animate(this, context) }

    context.stroke()
  }

  def draw_shape(context: dom.CanvasRenderingContext2D)
}
