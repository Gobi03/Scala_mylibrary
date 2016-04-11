// Longest Increasing Substring's length
// O(NlogN)
// 重複が存在しない前提

object LIS{
  val a = new Array[Int](42)
  // a に LIS 抜き出したいリストを配列として入力

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


  // LIS を返す
  def LIS(): List[Int] = {
    var lans = List(a(0))  // 完成した LIS が入る
    val dp = new Array[Int](a.length)
    dp(0) = a(0)
    var cnt = 1

    for(i <- 1 until a.length){
      if(a(i) >= dp(cnt-1)){  // 末端の要素より大きかったら
        dp(cnt) = a(i)
        lans = a(i) :: lans
        cnt += 1
      }
      else{
        val ind = binarySearch(0, cnt-1, a(i), dp)
        dp(ind) = a(i)
        if(ind == cnt - 1){  // 末尾書き換えたら lans 更新
          lans = Nil
          for(j <- 0 until cnt)
            lans = dp(j) :: lans
        }
      }
    }
    return lans
  }
}
