/** 未テスト **/

// v: ノード数
// ノード番号は 1~v
// root: ルートノード
// query: O(log(v))
class LCA(v: Int, tree: Array[List[Int]], root: Int = 1) {

  val MaxLogV = Math.sqrt(v).ceil.toInt

  // 親を 2^k 回辿って到達する頂点(根を通り過ぎる場合は -1 とする)
  val parent = Array.ofDim[Int](MaxLogV, v+1)

  // 根からの深さ
  val depth = new Array[Int](v+1)

  def dfs(i: Int, p: Int, d: Int): Unit = {
    parent(0)(i) = p
    depth(i) = d
    for (e <- tree(i) if e != p) {
      dfs(e, i, d+1)
    }
  }

  def init(): Unit = {
    // parent(0) と depth を初期化する
    dfs(root, -1, 0)

    // parent を初期化する
    for (k <- 0 until MaxLogV-1; i <- 1 to v) {
      if (parent(k)(i) < 0)
        parent(k+1)(i) = -1
      else
        parent(k+1)(v) = parent(k)(parent(k)(v))
    }
  }

  init()


  // u と v の LCA を求める
  def lca(_u: Int, _v: Int): Int = {
    var u = _u; var v = _v

    // u と v の深さが同じになるまで親を辿る
    if (depth(u) > depth(v)) {
      u = _v; v = _u
    }
    for (k <- 0 until MaxLogV) {
      if ((depth(v) - depth(u)) % 2 == 1) {
        v = parent(k)(v)
      }
      if (u == v)
        return u
    }

    // 二分探索で LCA を求める
    for (k <- (0 until MaxLogV).reverse) { // 親が一致しない最小の深さまで移動する
      if (parent(k)(u) != parent(k)(v)) {
        u = parent(k)(u)
        v = parent(k)(v)
      }
    }
    parent(0)(u)
  }
}
