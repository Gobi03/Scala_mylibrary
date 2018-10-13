// V: 頂点数
class BipartiteMatching(V: Int) {

  private[this] val G = Array.fill[List[Int]](V)(Nil) // グラフの隣接リスト表現
  private[this] val matching = Array.fill[Int](V)(-1) // マッチングのペア
  private[this] val used = new Array[Boolean](V)      // DFSで既に調べたかのフラグ

  // uとvを結ぶ辺をグラフに追加する
  def addEdge(u: Int, v: Int): Unit = {
    G(u) = v :: G(u)
    G(v) = u :: G(v)
  }

  // 増加パスをDFSで探す
  private[this] def dfs(v: Int): Boolean = {
    used(v) = true
    for(i <- 0 until G(v).length) {
      val u = G(v)(i)
      val w = matching(u)
      if(w < 0 || (!used(w) && dfs(w))) {
        matching(v) = u
        matching(u) = v
        return true
      }
    }
    return false
  }

  // 二部グラフの最大マッチングを求める
  def bipartiteMatching(): Int = {
    var res = 0
    for(v <- 0 until V) {
      if(matching(v) < 0) {
        for(i <- 0 until V)
          used(i) = false
        if(dfs(v)) {
          res += 1
        }
      }
    }

    res
  }
}
