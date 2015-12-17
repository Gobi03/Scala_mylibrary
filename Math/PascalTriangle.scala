/// test済み
//  pas = pascal(n)
//  nCk = pas(k)
//  n = 0 に対応していない

object Pascal{
  val MOD = 1000000007

  def pascal(n: Int): List[Int] = {
    // 次の段を作る
    def makeNext(list: List[Int], res: List[Int]): List[Int] = {
      list match{
        case x :: Nil => res :+ 1
        case x :: y :: list2 => makeNext(y :: list2, res :+ ((x+y)%MOD))
        case _ => throw new Exception("invalid list")
      }
    }

    // n回再起
    def pascalFunc(list: List[Int]): List[Int] = {
      (list.length > n) match{
        case true  => list
        case false => pascalFunc(makeNext(list, List(1)))
      }
    }

    pascalFunc(List(1))
  }
}
