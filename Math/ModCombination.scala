class ModComb(maxNum: Int, mod: Long) {

  private def repeatSquares(x: Long, n: Long): Long = {
    if(n == 0)
      1
    else if(n % 2 == 0)
      repeatSquares(x*x % mod, n/2)
    else
      (x * repeatSquares(x*x % mod, n/2)) % mod
  }

  private val fact = new Array[Long](maxNum + 1)

  fact(0) = 1
  for (i <- 1 to maxNum)
    fact(i) = (i * fact(i-1)) % mod

  private val factInv = new Array[Long](maxNum + 1)

  factInv(maxNum) = repeatSquares(fact(maxNum), mod-2)
  for (i <- (1 to maxNum).reverse)
    factInv(i-1) = (i * factInv(i)) % mod


  // nCk
  def comb(n: Int, k: Int): Long = {
    val numer = fact(n)
    val denom = (factInv(n-k) * factInv(k)) % mod

    (numer * denom) % mod
  }

}
