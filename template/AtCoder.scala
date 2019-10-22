import java.io._
import java.util.StringTokenizer
import scala.util.control.Breaks.{breakable,break}
import scala.collection.mutable.{Map, Stack, Queue, PriorityQueue}

object Main extends App {
  val in = new InputReader(System.in)
  val pw = new PrintWriter(System.out)

  // val n = in.next().toInt
  // val a, b = in.next().toInt
  // val s = in.next()

  // val a = new Array[Int](N)


}


class InputReader(stream: InputStream) {
  private[this] val reader = new BufferedReader(new InputStreamReader(stream))
  private[this] var tokenizer: StringTokenizer = new StringTokenizer(reader.readLine())
  def next(): String = {
    while (!tokenizer.hasMoreTokens()) {
      tokenizer = new StringTokenizer(reader.readLine())
    }
    tokenizer.nextToken()
  }
}

object Sub {
  def print2DimArray[A](mat: Array[Array[A]]): Unit = {
    mat.foreach(lin => println(lin.deep))
  }
}
