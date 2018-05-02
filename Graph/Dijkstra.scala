// 要テスト

// O(E log(V))
import scala.util.control.Breaks.{breakable,break}
import scala.collection.mutable.PriorityQueue


val edge = new Array[List[(Int, Int)]](v)  // (node, cost)


// fro から to への最短距離(v は頂点数)
def dijkstra(from: Int, to: Int, v: Int): Int = {
  val MAX = Int.MaxValue

  val dist = Array.fill(v)(MAX)   // fro からの距離を格納する
  val check = new Array[Boolean](v)  // すでにその頂点からを調べたかのフラグ

  dist(from) = 0

  val pq = new PriorityQueue[(Int, Int)]  // (-cost, node) queue
  pq.enqueue((-0, from))

  // 頂点は v 個あるので、v 周する
  for(_ <- 0 until v) {
    // 調べ済みでない頂点のうち、最も近い頂点を now に入れる
    var nowNode = -1       // このターンにフォーカスするノード

    breakable {
      while(true) {
        nowNode = pq.dequeue._2  // 最小コストから貪欲に取っていく
        if(!check(nowNode)){  // まだチェックされていないノードだったら決定
          check(nowNode) = true
          break
        }
      }
    }

    // その頂点からたどり着ける頂点の情報を更新する
    for((nextNode, cost) <- edge(nowNode)) {
      val nextDist = dist(nowNode) + cost
      if(nextDist < dist(nextNode)){  // 既存の通路より近いなら更新
        dist(nextNode) = nextDist
        pq.enqueue((-nextDist, nextNode))
      }
    }
  }

  dist(to)
}
