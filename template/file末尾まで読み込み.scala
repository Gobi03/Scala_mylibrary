object Main{
  // val n = io.StdIn.readInt
  // val Array(n, m) = io.StdIn.readLine.split(' ').map(_.toInt)
  // val as = io.StdIn.readLine.split(' ').map(_.toInt).toList

  def main (args: Array[String]){
    try {
      while(true){
        val n = io.StdIn.readInt
        println(n)
      }
    } catch {
      case e: NumberFormatException => ()
    }
  }
}
