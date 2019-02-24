map(x => x + 1) , map(_ + 1)
list.filter(f)  // 述語fにおいて真のリスト
list.count(f)　:Int  // fが真の個数
list.updated(i, x)   // update i-th element to x
forall(_ > 2) , exists(_ > 2)  // :Boolean
list.indexWhere(f) :Int // f(_)が真になる最初の i
sortWith(f)  // 比較関数fの元でソート
list.zipWithIndex  // 値とindexの組のリストに変換


list.reduceLeft((a,b) => a + b)  // sum
list.reduceLeft(_ + _)          // sum

// reduceRightがright_foldなので直観的に使いやすい


// listの要素への繰り返し処理
list.foreach { println }
for (x <- list) { println(x) }

for (x <- list) yield x+1 :List[Int]  // mapと同様の処理

for (i <- list; j <- list) yield 10*i+j
for (i <- 1 to 3; j <- 1 to 3) yield 10*i+j
for (i <- 1 to 3; j <- 1 to 3 if i != j) yield 10*i+j

// input
val a = List.fill(N)(sc.nextInt)
