// 基本
var ar = new Array[Int](n)   //n要素のarrayを生成
ar(i)    //take an i-th element
ar(i) = num   //numをar(i)に代入
ar.sorted    // 昇順にsortしたarrayを返す

// 要素を直接取り出すループ。
for (e <- a) {
  println(e)
}

a1.sameElements(a2)   //一次元配列でのみ使用可

var s: Array[String] = Array.fill(n)("")   //n-arrayを "" でinitialize

a.foreach{ e => println(e) }
a.foreach{ println(_) }
a.foreach(println)

// 多次元配列
val array = Array.ofDim[Int](2, 3)  // int[2][3]
println(array(1)(2))
println(array.deep)

deep  // 配列の中身も見れる

