// 要テスト

// 上に凸のグラフの最大値
def ternarySearch(small: Double, big: Double): Double = {
  val END = 5e-9
  val VOL = 1e-9  // (END / 2) より小さい
  def func(small: Double, big: Double): Double = {
    val midl = (big + small) / 2
    val midr = midl + VOL
    if (big - small < END) big
    else {
      if (check(midl) <= check(midr))
        func(midl, big)
      else
        func(small, midr)
    }
  }
  func(small, big)
}


// 下に凸のグラフの最小値
def ternarySearch(small: Double, big: Double): Double = {
  val END = 5e-9
  val VOL = 1e-9  // (END / 2) より小さい
  def func(small: Double, big: Double): Double = {
    val midl = (big + small) / 2
    val midr = midl + VOL
    if (big - small < END) big
    else {
      if (check(midl) >= check(midr))
        func(midl, big)
      else
        func(small, midr)
    }
  }
  func(small, big)
}
