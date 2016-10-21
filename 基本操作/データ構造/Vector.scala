// http://www.geocities.jp/m_hiroi/java/scala18.html

Vector.empty[Int]
val b = Vector(1, 2, 3, 4, 5)
b: scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4, 5)

// index
b(0)

// cons
0 +: b
// snoc
b :+ 6
// append
b ++ Vector(6, 7, 8, 9)

// update  (index, element)
b.updated(0, 5)

// generation
empty                         : 空の列を生成する。
concat(col1, col2, ...)       : 他のコレクションから列を生成する。
fill(大きさ)(値)              : 列を指定した値で満たす。
tabulate(大きさ)(関数)        : 添字に関数を適用して、返り値を列に格納して返す。
iterate(初期値, 大きさ)(関数) : 前の要素に関数を適用して、その返り値を列に格納して返す。
range(開始, 終了, [増分])     : 指定した範囲の数列を生成する。


drop(n)  // 最初のn個の要素を除いたリスト
dropRight(n)  // 最後のn個の要素を除いたリスト
