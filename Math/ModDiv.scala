// 素数modulo `p` の世界での割り算

// a / b
def modDiv(a: Int, b: Int, p: Int): Long = {

  // (x ^ n) % p
  def repeatSquares(x: Long, n: Int): Long = {
    if(n == 0)
      1
    else if(n % 2 == 0)
      repeatSquares(x*x % p, n/2)
    else
      (x * repeatSquares(x*x % p, n/2)) % p
  }

  val numer = a % p
  val denom = repeatSquares(b, p-2)

  (numer * denom) % p
}
