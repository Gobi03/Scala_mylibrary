// O(log min(a, b))
// 最大公約数
// ユークリッドの互除法
def gcd(a: Long, b: Long): Long = {
  if (b == 0) a
  else gcd(b, a % b)
}
