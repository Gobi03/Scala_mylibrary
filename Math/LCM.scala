// 最小公倍数
// ユークリッドの互除法
def lcm(a: Long, b: Long): Long = {
  def gcd(a: Long, b: Long): Long = {
    if (b == 0) a
    else gcd(b, a % b)
  }

  a * b / gcd(a, b)
}
