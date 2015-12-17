// Longest Increasing Substring's length
// O(NlogN) になってないかも？
// 重複が存在しない前提

object LIS{

  // listの最長部分文字列の長さを返す
  def lisLength(list: List[Int]): Int = {
    // search out's update point "i" by binary search
    def searchPoint(x: Int, out: List[Int]): Int = {
      def binarySearch(min: Int, max: Int): Int = {
        val mid: Int = (max + min) / 2;
        (max - min) match{
          case 0 | 1 =>
            out(min) > x match{
              case true  => min
              case false => max
            }
          case _ =>
            out(mid) > x match{
              case true  => binarySearch(min, mid)
              case false => binarySearch(mid, max)
            }
        }
      }

      binarySearch(0, out.length-1)
    }

    // outがどんなListになるか調べるbase function
    def check(x: Int, out: List[Int]) = {
      out match{
        case Nil => List(x)
        case _ =>
          (out.last < x) match{
            case true  => out :+ x
            case false => out.updated(searchPoint(x, out), x)
          }
      }
    }

    // function base
    def func(in: List[Int], out: List[Int]): Int = {
      in match{
        case Nil => out.length
        case x :: in2 => func(in2, check(x, out))
      }
    }

    func(list, Nil)
  }
}
