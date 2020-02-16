// O(|V|*|E|)
case class Edge(from: Int, to: Int, cost: Long)

// V: 頂点数, E: 辺数
// 0-based index
class BellmanFord(V: Int, E: Int, es: Array[Edge]) {

  val d = new Array[Long](V) // 最短距離

  private[this] val INF = Long.MaxValue

  // s番目の頂点から各頂点への最短距離を求める
  // 負のループがあると止まらない
  def shortestPath(s: Int): Unit = {
    for (i <- 0 until V)
      d(i) = INF

    d(s) = 0
    breakable {
      while (true) {
        var update = false
        for(i <- 0 until E) {
          val e = es(i)
          if (d(e.from) != INF && d(e.to) > d(e.from) + e.cost) {
            d(e.to) = d(e.from) + e.cost
            update = true
          }
        }

        if (!update)
          break
      }
    }
  }

  // true なら負の閉路が存在する
  def findNegativeLoop(): Boolean = {
    for (i <- 0 until V)
      d(i) = 0

    for (i <- 0 until V) {
      for (j <- 0 until E) {
        val e = es(j)
        if (d(e.to) > d(e.from) + e.cost) {
          d(e.to) = d(e.from) + e.cost

          // n 回目にも更新があるなら負の閉路が存在する
          if (i == V - 1)
            return true
        }
      }
    }

    false
  }

}
