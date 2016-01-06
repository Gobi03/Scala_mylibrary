// Longest Increasing Substring's length
// O(NlogN)
// 副作用あり
// 重複が存在しない前提

object LIS{

  val a = new Array[Int](42)  // subsequence 求めるarray
  val al = a.length
  var dplis = new Array[Int](al)

  var index = 0
  dplis(0) = a(0)

  // search dplis's update point by binary search
  def searchPoint(index: Int, x: Int): Int = {
    def binarySearch(min: Int, max: Int): Int = {
      val mid: Int = (max + min) / 2;
      (max - min) match{
        case 0 | 1 =>
          dplis(min) > x match{
            case true  => min
            case false => max
          }
        case _ =>
          dplis(mid) > x match{
            case true  => binarySearch(min, mid)
            case false => binarySearch(mid, max)
          }
      }
    }

    binarySearch(0, index)
  }

  for(i <- 1 until al){
    a(i) > dplis(index) match{
      case true  =>
        index += 1
        dplis(index) = a(i)
      case false =>
        val p = searchPoint(index, a(i))
        dplis(p) = a(i)
    }
  }

  return (index + 1)
}
