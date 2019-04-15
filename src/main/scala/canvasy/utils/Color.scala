package canvasy.utils

import canvasy.elements.CanvasyElement


class Color(val code: String)

object Color {
  val black = rgb"#000000"
  val red = rgb"#ff0000"

  def apply(code: String) = new Color(code)


  implicit class ColorHelper(private val sc: StringContext) extends AnyVal {
    def rgb(args: Any*) = Color(sc.parts.mkString)
  }
}
