// 条件を満たす最大の値を返す
def binarySearch(_min: Int, _max: Int): Int = {
  def check(i: Int): Boolean = ???

  def func(min: Int, max: Int): Int = {
    val mid: Int = (max + min) / 2
      (max - min) match{
      case 0 | 1 =>
        check(max) match{
          case true  => max
          case false => min
        }
      case _ =>
        (check(mid)) match{
          case true  => func(mid, max)
          case false => func(min, mid)
        }
    }
  }

  func(_min, _max)
}

// 条件を満たす最小の値を返す
def binarySearch(_min: Int, _max: Int): Int = {
  def check(i: Int): Boolean = ???

  def func(min: Int, max: Int): Int = {
    val mid: Int = (max + min) / 2
      (max - min) match{
      case 0 | 1 =>
        check(min) match{
          case true  => min
          case false => max
        }
      case _ =>
        (check(mid)) match{
          case true  => func(min, mid)
          case false => func(mid, max)
        }
    }
  }

  func(_min, _max)
}
