package canvasy.elements

import org.scalajs.dom

import canvasy.properties.{Animateable, Selectable}


class Image(var width: Int, var height: Int, var x: Int, var y: Int, src: String) extends CanvasyElement
        with Animateable with Selectable {


  def adapt_position(mouse_x: Int, mouse_y: Int, offset_x: Int, offset_y: Int) {
    x = mouse_x + offset_x
    y = mouse_y + offset_y
  }


  def move(vx: Int, vy: Int) { x += vx; y += vy }
  def is_on_x_border(max_x: Double, vx: Int) = (x + width + vx > max_x || x + vx < 0)
  def is_on_y_border(max_y: Double, vy: Int) = (y + height + vy > max_y || y + vy < 0)


  def draw(context: dom.CanvasRenderingContext2D) {
    var div = dom.document.getElementById("images").asInstanceOf[dom.raw.HTMLElement]
    if(div == null) {
      div = dom.document.createElement("div").asInstanceOf[dom.raw.HTMLElement]
      div.style = "display:none;"
      div.setAttribute("id", "images")
      dom.document.body.appendChild(div)
    }

    var img = dom.document.getElementById(src).asInstanceOf[dom.raw.HTMLElement]
    if(img== null) {
      img = dom.document.createElement("img").asInstanceOf[dom.raw.HTMLElement]
      div.appendChild(img)
      img.setAttribute("id", src)
      img.setAttribute("src", src)
      img.setAttribute("width", width.toString)
      img.setAttribute("height", height.toString)
    }

    context.drawImage(img, x, y, width, height)

    if(super[Animateable].is_animatable())  { super[Animateable].animate(this, context) }
  }
}
