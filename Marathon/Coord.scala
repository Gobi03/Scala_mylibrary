case class Coord(x: Int, y: Int) {

  val H: Int = ???; val W: Int = ???

  def this(p: (Int, Int)) = this(p._1, p._2)

  def +(co: Coord): Coord = {
    Coord(this.x + co.x, this.y + co.y)
  }

  def -(co: Coord): Coord = {
    Coord(this.x - co.x, this.y - co.y)
  }

  def inField: Boolean = {
    0 <= x && x < W && y <= 0 && y < H
  }

  def mk4dir: List[Coord] = {
    val delta = List((1, 0), (0, 1), (-1, 0), (0, -1)).map(p => Coord(p._1, p._2))
    delta
      .map(_ + this)
      .filter(_.inField)
  }

  def mk8dir: List[Coord] = {
    val delta = List(
      (1, 0), (0, 1), (-1, 0), (0, -1),
      (1, 1), (-1, 1), (-1, -1), (1, -1)
    ).map(p => Coord(p._1, p._2))

    delta
      .map(_ + this)
      .filter(_.inField)
  }

}
