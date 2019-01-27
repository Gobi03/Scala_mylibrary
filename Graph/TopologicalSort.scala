// topological sort
// log(V+E)


val graph = Array.fill[List[Int]](V+1)(Nil) // 隣接リスト
val indegree = new Array[Int](V+1) // 入次数

var res = List[Int]() // ソート結果

// input
for (_ <- 1 to E) {
  val a, b = in.next().toInt
  graph(a) = b :: graph(a)
  indegree(b) += 1
}

var deg0 = new scala.collection.mutable.Stack[Int]
for (i <- 1 to V) {
  if(indegree(i) == 0)
    deg0.push(i)
}


while(!deg0.isEmpty) {
  val node = deg0.pop()
  res = node :: res
  for (e <- graph(node)) {
    indegree(e) -= 1 // 隣接する頂点の入次数をマイナス1
    if (indegree(e) == 0) // これによって入次数が0になればstに追加
      deg0.push(e)
  }
}

res = res.reverse
