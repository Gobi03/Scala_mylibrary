val q = new scala.collection.mutable.Queue[Int]
q += 初期値

while(!q.isEmpty){
  val now = q.dequeue

  // 状態 now に対する処理

  q += next
}
