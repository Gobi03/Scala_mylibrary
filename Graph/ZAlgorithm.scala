// O(|S|)
// https://qiita.com/Pro_ktmr/items/16904c9570aa0953bf05

class ZAlgorithm(S: String) {
  private[this] val N = S.length

  // Z配列
  val Z = new Array[Int](N)

  Z(0) = N
  private[this] var i = 1
  private[this] var j = 0
  while (i < N) {
    while (i + j < N && S(j) == S(i+j))
      j += 1
    Z(i) = j

    if (j == 0) {
      i += 1
    }
    else {
      var k = 1
      while (k < j && k + Z(k) < j) {
        Z(i+k) = Z(k)
        k += 1
      }
      i += k
      j -= k
    }
  }
}
