// 基本
var ar = new Array[Int](n)   //n要素のarrayを生成
ar.sorted    // 昇順にsortしたarrayを返す

val d = Array.fill(10)(0);
// d: Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

a1.sameElements(a2)   //一次元配列でのみ使用可

var s: Array[String] = Array.fill(n)("")   //n-arrayを "" でinitialize

a.foreach{ println(_) }
a.foreach(println)

// 多次元配列
val array = Array.ofDim[Int](2, 3)  // int[2][3]
println(array(1)(2))
println(array.deep)

clone  // 値渡しとしてのコピー
deep  // 配列の中身も見れる

// sort
scala.util.Sorting.quickSort(ar)
