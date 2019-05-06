package canvasy.utils

import scala.math.{min, max}

import canvasy.elements.Point
import canvasy.elements.shapes.Polygon


// Application of algorithm: https://www.geeksforgeeks.org/how-to-check-if-a-given-point-lies-inside-a-polygon/
object PolygonUtils {
  // Check if q lies on segment pr
  def onSegment(p: Point, q: Point, r: Point): Boolean = {
    return q.x <= max(p.x, r.x) && q.x >= min(p.x, r.x) && q.y <= max(p.y, r.y) && q.y >= min(p.y, r.y)
  }

  // Find the orientation of ordered triplet (p, q, r)
  // 0 --> p, q and r are colinear
  // 1 --> Clockwise
  // 2 --> Counterclockwise
  def orientation(p: Point, q: Point, r: Point): Int = {
    val rt = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y)

    if(rt == 0)     { return 0 }
    else if(rt > 0) { return 1 }
    else            { return 2 }
  }

  def doIntersect(p1: Point, q1: Point, p2: Point, q2: Point): Boolean = {
    val o1: Int = orientation(p1, q1, p2)
    val o2: Int = orientation(p1, q1, q2)
    val o3: Int = orientation(p2, q2, p1)
    val o4: Int = orientation(p2, q2, q1)

    // General case
    if(o1 != o2 && o3 != o4)              { return true }

    // Special Cases
    if(o1 == 0 && onSegment(p1, p2, q1))  { return true }
    if(o2 == 0 && onSegment(p1, q2, q1))  { return true }
    if(o3 == 0 && onSegment(p2, p1, q2))  { return true }
    if(o4 == 0 && onSegment(p2, q1, q2))  { return true }

    false
  }

  // Returns true if the point p lies inside the Polygon with n vertices
  def isInside(polygon: Polygon, n: Int, p: Point): Boolean = {
    if(n < 3) { return false }

    // Create a point for line segment from p to infinite
    val extreme: Point = Point(100000, p.y)

    // Count intersections of the above line with sides of polygon
    var count: Int = 0
    for(i <- 0 to (n - 1)) {
      val next: Int = (i + 1) % n

      if(doIntersect(polygon(i), polygon(next), p, extreme)) {
        // If the point 'p' is colinear with line segment 'i-next',
        // then check if it lies on segment. If it lies, return true,
        // otherwise false
        if(orientation(polygon(i), p, polygon(next)) == 0) {
          return onSegment(polygon(i), p, polygon(next))
        }
        count += 1
      }
    }

    return count % 2 == 1
  }
}
