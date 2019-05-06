package canvasy.properties


trait Constructable {
  var construction_percentage: Int = 100


  def advance_construction() = {
    if(!is_constructed())
      construction_percentage += 1
  }

  def is_constructed() = { construction_percentage == 100 }

  def animate_construction() = { construction_percentage = 0 }
}
