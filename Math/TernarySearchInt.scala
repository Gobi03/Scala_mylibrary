// check は数値を返す

// 上に凸のグラフの最大値
def ternarySearchInt(small: Int, big: Int): Int = {
  if(big - small <= 2) {
    val mid = (big + small) / 2
    if(check(big) >= check(mid)) big
    else if(check(small) >= check(mid)) small
    else mid
  }
  else{
    val midl = (big + small) / 2
    val midr = midl + 1
    if (check(midl) <= check(midr))
      ternarySearchInt(midl, big)
    else
      ternarySearchInt(small, midr)
  }
}


// 下に凸のグラフの最小値
def ternarySearchInt(small: Int, big: Int): Int = {
  if(big - small <= 2) {
    val mid = (big + small) / 2
    if(check(big) <= check(mid)) big
    else if(check(small) <= check(mid)) small
    else mid
  }
  else{
    val midl = (big + small) / 2
    val midr = midl + 1
    if (check(midl) >= check(midr))
      ternarySearchInt(midl, big)
    else
      ternarySearchInt(small, midr)
  }
}
