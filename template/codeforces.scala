object Main {
  import java.io._
  import java.util.StringTokenizer
  import scala.util.control.Breaks.{breakable,break}
  import scala.collection.mutable.{Map, Stack, Queue, PriorityQueue}

  val in = new InputReader(System.in)
  val pw = new PrintWriter(System.out)

  def main (args: Array[String]){
    // val n = in.next().toInt
    // val a, b = in.next().toInt
    // val s = in.next()


  }
}

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
