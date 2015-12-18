// reference: http://bach.istc.kobe-u.ac.jp/lect/ProLang/org/scala-sieve.html
// prime(n) : n以下の素数のリストを返す。
object Sieve{
  def sieve(l: List[Int]): List[Int] =
    l.isEmpty match{
      case true  => Nil
      case false => l.head :: sieve(l.tail.filter(_ % xs.head != 0))
    }

  def primes(n: Int): List[Int] = sieve(Range(2, n).toList)

  def main(args: Array[String]){
    primes(100).foreach {println}
  }
}
