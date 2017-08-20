// O(α(n)) << O(log(n))
// v は頂点数

class UnionFind(v: Int){
  // 根であれば *そのグループの要素数(負)* が、子であれば親の番号が入る。
  val uni = Array.fill(v)(-1)

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
    uni(rb) = ra
    return true
  }

  // 頂点 a, b が同じグループであるかを調べる
  def isConnect(a: Int, b: Int): Boolean =
    root(a) == root(b)

  // 頂点 a を含むグループの頂点数を調べる
  def size(a: Int): Int = -uni(root(a))
}
