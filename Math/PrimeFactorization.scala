  // 素数とその個数の組のリストを返す
  def primeFactorization(n: Long): List[(Long, Int)] = {
    var rest = n
    var res: List[(Long, Int)] = Nil

    var i = 2L
    while (i * i <= n) {
      var cnt = 0
      while (rest % i == 0) {
        cnt += 1
        rest /= i
      }

      if (cnt > 0)
        res = (i, cnt) :: res

      i += 1
    }
    if (rest > 1)
      res = (rest, 1) :: res

    res.reverse
  }
