import java.io._
import java.util.StringTokenizer

object Main extends App {
  val in = new InputReader(System.in)
  val pw = new PrintWriter(System.out)
  // val n = in.next().toInt
  // val a, b = in.next().toInt
  // val s = in.next()


}


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

