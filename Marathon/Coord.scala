case class Coord(x: Int, y: Int) extends Ordered[Coord] {

  val H: Int = ???; val W: Int = ???

  def this(p: (Int, Int)) = this(p._1, p._2)

  def compare(that: Coord): Int = {
    if (this.x != that.x)
      this.x.compare(that.x)
    else
      this.y.compare(that.y)
  }

  def +(co: Coord): Coord = {
    Coord(this.x + co.x, this.y + co.y)
  }
  def -(co: Coord): Coord = {
    Coord(this.x - co.x, this.y - co.y)
  }
  def *(n: Int): Coord = {
    Coord(this.x * n, this.y * n)
  }

  def toPair: (Int, Int) = (x, y)

  def inField: Boolean = {
    0 <= x && x < W && 0 <= y && y < H
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

  def dist(that: Coord): Int = {
    (this.x - that.x).abs + (this.y - that.y).abs
  }

  def get2dim[A](ar: Array[Array[A]]): A = {
    ar(this.y)(this.x)
  }

  // this から見て that がどの方向にあるか見る
  def direct(that: Coord): Seq[String] = {
    var res = Seq[String]()

    if (this.x < that.x)      res = res :+ "R"
    else if (this.x > that.x) res = res :+ "L"

    if (this.y < that.y)      res = res :+ "D"
    else if (this.y > that.y) res = res :+ "U"

    res
  }

}
