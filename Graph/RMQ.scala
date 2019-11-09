// MaxN : 2の乗数でないといけない。要素数に応じた値。(e.g. 10^5なら1<<17にしておくとよい)
class RMQ(MaxN: Int) {

  val dat = Array.fill[Long](2*MaxN - 1)(Long.MaxValue)

  // k番目の値(0-indexed)をaに変更
  def update(_k: Int, a: Long): Unit = {
    // 葉の節点
    var k = _k + (MaxN - 1)
    dat(k) = Math.min(dat(k), a)

    // 登りながら更新
    while (k > 0) {
      k = (k-1) / 2
      dat(k) = Math.min(dat(2*k + 1), dat(2*k + 2))
    }
  }

  // [a, b) の最小値を求める
  // 後ろの方の引数は、計算の簡単のための引数
  // kは節点の番号。l, r はその節点が[l, r) に対応づいていることを表す。
  def query(a: Int, b: Int): Long = {
    def func(k: Int, l: Int, r: Int): Long = {
      if (r <= a || b <= l) // [a, b)と[l, r)が交差しなければ、Int.MaxValue
        Long.MaxValue
      else if (a <= l && r <= b) // [a, b)が[l, r)を完全に含んでいれば、この節点の値
        dat(k)
      else { // そうでなければ、２つの子の最小値
        val vl = func(2*k + 1, l, (l+r)/2)
        val vr = func(2*k + 2, (l+r)/2, r)

        Math.min(vl, vr)
      }
    }

    func(0, 0, MaxN)
  }

  def print(n: Int): Unit = {
    val vol = MaxN - 1
    println(dat.slice(vol, vol+n + 1).deep)
  }

}
