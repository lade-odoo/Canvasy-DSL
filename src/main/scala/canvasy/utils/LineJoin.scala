package canvasy.utils

import canvasy.elements.CanvasyElement


class LineJoin(val code: String)

object LineJoin {
  val default = lj"mitter"
  val round = lj"round"
  val bevel = lj"bevel"

  def apply(code: String) = new LineJoin(code)


  implicit class LineJoinHelper(private val sc: StringContext) extends AnyVal {
    def lj(args: Any*) = LineJoin(sc.parts.mkString)
  }
}
