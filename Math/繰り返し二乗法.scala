// (x ^ n) % mod
def repeatSquares(x: Long, n: Int, mod: Int): Long = {
  if(n == 0)
    1
  else if(n % 2 == 0)
    repeatSquares(x*x % mod, n/2, mod)
  else
    (x * repeatSquares(x*x % mod, n/2, mod)) % mod
}
