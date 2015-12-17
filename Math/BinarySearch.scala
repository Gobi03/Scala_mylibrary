// 最大値を返す
def binarySearch(min: Int, max: Int): Int = {
  val mid: Int = (max + min) / 2;
  (max - min) match{
    case 0 | 1 =>
      isWell(max) match{
        case true  => max
        case false => min
      }
    case _ =>
      (isWell(mid)) match{
        case true  => binarySearch(mid, max)
        case false => binarySearch(min, mid)
      }
  }

// 最小値を返す
def binarySearch(min: Int, max: Int): Int = {
  val mid: Int = (max + min) / 2;
  (max - min) match{
    case 0 | 1 =>
      isWell(min) match{
        case true  => min
        case false => max
      }
    case _ =>
      (isWell(mid)) match{
        case true  => binarySearch(min, mid)
        case false => binarySearch(mid, max)
      }
  }
