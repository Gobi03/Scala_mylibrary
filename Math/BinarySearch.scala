// 条件を満たす最大の値を返す
def binarySearch(min: Int, max: Int): Int = {
  val mid: Int = (max + min) / 2;
  (max - min) match{
    case 0 | 1 =>
      check(max) match{
        case true  => max
        case false => min
      }
    case _ =>
      (check(mid)) match{
        case true  => binarySearch(mid, max)
        case false => binarySearch(min, mid)
      }
  }

// 条件を満たす最小の値を返す
def binarySearch(min: Int, max: Int): Int = {
  val mid: Int = (max + min) / 2;
  (max - min) match{
    case 0 | 1 =>
      check(min) match{
        case true  => min
        case false => max
      }
    case _ =>
      (check(mid)) match{
        case true  => binarySearch(min, mid)
        case false => binarySearch(mid, max)
      }
  }
