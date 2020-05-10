// (x ^ n) % mod
def repeatSquares(x: Long, n: Int, mod: Int): Long = {
  def func(x: Long, n: Int): Long = {
    if(n == 0)
      1
    else if(n % 2 == 0)
      func(x*x % p, n/2)
    else
      (x * func(x*x % p, n/2)) % p
  }

  if (x == 0 && n != 0) 0
  else func(x, n)
}
