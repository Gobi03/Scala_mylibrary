// 要テスト

// O(E log(V))
import scala.collection.mutable.PriorityQueue

val edge = new Array[List[Int]](v)  // 頂点 i から行くことができる頂点のリスト
val dist = Array.ofDim[Int](a, b)  // 頂点 a から頂点 b に移動するコスト

// fro から to への最短距離(v は頂点数)
def dijkstra(from: Int, to: Int, v: Int): Int = {
  val MAX = 1e9.toInt

  val d = Array.fill(v)(MAX)   // fro からの距離を格納する
  val check = new Array[Boolean](v)  // すでにその頂点からを調べたかのフラグ

  d(from) = 0
  // priority queue: (cost, node) queue
  val pq = new PriorityQueue[(Int, Int)]
  pq.enqueue((0, from))

  // 頂点は v 個あるので、v 周する
  for(i <- 0 until v) {
    // 調べ済みでない頂点のうち、最も近い頂点を now に入れる
    var now = -1       // このターンにフォーカスするノード
    var nowdis = MAX   // その距離

    var flag = true
    while(flag){
      now = pq.dequeue._2  // 最小コストから貪欲に取っていく
      if(!check(now)){  // まだチェックされていないノードだったら決定
        check(now) = true
        nowdis = d(now)
        flag = false
      }
    }

    // その頂点からたどり着ける頂点の情報を更新する
    for(next <- edge(now)){  // nex はたどり着ける頂点
      val nextdis = d(now) + dist(now)(next)
      if(nextdis < d(next)){  // 既存の通路より近いなら更新
        d(next) = nextdis
        pq.enqueue((d(next), next))
      }
    }
  }

  return d(to)
}
