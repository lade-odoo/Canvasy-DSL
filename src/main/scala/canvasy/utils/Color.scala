package canvasy.utils

import canvasy.elements.CanvasyElement


class Color(val code: String)

object Color {
  val white = rgb"#FFFFFF"
  val black = rgb"#000000"
  val red = rgb"#FF0000"
  val blue = rgb"#0000FF"
  val green = rgb"#ADFF2F"
  val yellow = rgb"#FFD700"
  val cyan = rgb"#00FFFF"
  val orange = rgb"#FFA500"
  val pink = rgb"#FFC0CB"
  val purple = rgb"##E6E6FA"
  val brown = rgb"#FFF8DC"
  val gray = rgb"#808080"


  def apply(code: String) = new Color(code)

  def random() = {
    scala.util.Random.nextInt(11) match {
      case 0 => black
      case 1 => red
      case 2 => blue
      case 3 => green
      case 4 => yellow
      case 5 => cyan
      case 6 => orange
      case 7 => pink
      case 8 => purple
      case 9 => brown
      case 10 => gray
    }
  }


  implicit class ColorHelper(private val sc: StringContext) extends AnyVal {
    def rgb(args: Any*) = Color(sc.parts.mkString)
  }
}
