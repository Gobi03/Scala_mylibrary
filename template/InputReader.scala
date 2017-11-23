https://qiita.com/nel215/items/2cc03daaac29b03af176#%E5%85%A5%E5%8A%9B%E3%82%AF%E3%83%A9%E3%82%B9%E3%82%92%E4%BD%9C%E3%81%A3%E3%81%A6%E4%BD%BF%E3%81%86

import java.io._
import java.util.StringTokenizer

class InputReader(stream: InputStream) {
  private val reader = new BufferedReader(new InputStreamReader(stream))
  private var tokenizer: StringTokenizer = new StringTokenizer(reader.readLine())
  def next(): String = {
    while (!tokenizer.hasMoreTokens()) {
      tokenizer = new StringTokenizer(reader.readLine())
    }
    tokenizer.nextToken()
  }
}

object Main extends App {
  val in = new InputReader(System.in)
 
  val n = in.next().toInt
  val a, b = in.next().toInt
  val s = in.next()
}
