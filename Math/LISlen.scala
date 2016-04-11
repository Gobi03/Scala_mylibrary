// Longest Increasing Substring's length
// O(NlogN)
// 重複が存在しない前提

object LISlen{
  val a = new Array[Int](42)
  // a に LIS 求めたいリストを配列として入力

  // binary search
  // 条件を満たす最小の値を返す
  def binarySearch(min: Int, max: Int, ins: Int, dp: Array[Int]): Int = {
    val mid: Int = (max + min) / 2;
    (max - min) match{
      case 0 | 1 =>
        ins < dp(min) match{
          case true  => min
          case false => max
        }
      case _ =>
        ins < dp(mid) match{
          case true  => binarySearch(min, mid, ins, dp)
          case false => binarySearch(mid, max, ins, dp)
        }
    }
  }


  // LIS length
  def LISlen(): Int = {
    val dp = new Array[Int](a.length)
    dp(0) = a(0)
    var cnt = 1

    for(i <- 1 until a.length){
      if(a(i) >= dp(cnt-1)){  // 末端の要素より大きかったら
        dp(cnt) = a(i)
        cnt += 1
      }
      else{
        val ind = binarySearch(0, cnt-1, a(i), dp)
        dp(ind) = a(i)
      }
    }
    return cnt
  }
}
