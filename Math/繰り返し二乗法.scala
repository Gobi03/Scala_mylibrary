// x ^ n
class Main{
  val mod = 1000000007
  def repeatSquares(x: Long, n: Int): Int = {
    n match{
      case 0 => 1
      case _ =>
        n % 2 == 0 match{ 
          case true  => repeatSquares(x*x % mod, n/2)
          case false =>
            ((x * repeatSquares(x*x % mod, n/2).toLong) % mod).toInt
        }
    }
  }
}
