// O(E log|V|)
// V は頂点数
// E はノード数


/* Union-Find */
val uni = Array.fill(v)(-1)  // 根であれば *そのグループの要素数(負)* が、子であれば親の番号が入る。

// 頂点 v の所属するグループを調べる
def root(v: Int): Int =
  uni(v) < 0 match{
    case true  =>  // v が親の場合
      return v
    case false =>  // v が子の場合
      uni(v) = root(uni(v))  // 親のrootを調べる
      return uni(v)
  }

// 頂点 a と頂点 b をつなぐ。もともと同じグループのとき、False を返す
def connect(a: Int, b: Int): Boolean = {
  // まずはそれぞれ根の番号に置き換える
  var ra = root(a)
  var rb = root(b)
  if(ra == rb)
    return false  // a と b がそもそも同じグループに属しているなら即終了

  // ra を大きなグループにしたいので、逆であれば入れ替える
  if(uni(ra) > uni(rb)) {  // rbの方が要素数が多ければ
    var tmp = ra
    ra = rb
    rb = tmp
  }

  // ra と rb を結合し、rb の親を ra とする
  uni(ra) += uni(rb)
  uni(rb) += ra
  return true
}

// 頂点 a, b が同じグループであるかを調べる
def isConnect(a: Int, b: Int): Boolean =
  root(a) == root(b)


/* Kruskal法 */
// edge は cost, from, to のタプルで表す
val edges = new Array[(Int, Int, Int)](E)

// edges 入力

def kruskal(): Int = {
  edges.sorted  // edge のコストが小さい順にソートする

  var res = 0
  for(ed <- edges){
    if(!isConnect(ed._2, ed._3)){
      connect(ed._2, ed._3)
      res += ed._1
    }
  }

  return res
}
