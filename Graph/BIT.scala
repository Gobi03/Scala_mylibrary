// 未テスト

// [1, n]
// n is num of element
class BIT(n: Int) {
  val ar = new Array[Int](n+1)

  // sum of [1, i]
  def sum(i: Int): Int = {
    def func(i: Int, res: Int): Int = {
      if(i <= 0)
        res
      else
        func(i - (i & -i), res + ar(i))
    }
    func(i, 0)
  }

  // add x to i-th element
  def add(i: Int, x: Int): Unit = {
    def func(i: Int): Unit = {
      if(i > n)
        ()
      else {
        ar(i) += x
        func(i + (i & -i))
      }
    }
    func(i)
  }
}
