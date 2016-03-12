math.Pi

Range(m, n) , (m until n)  // m以上n未満
(m to n)  // m以上n以下
(m to n by k)  // m以上n以下をmからk置きに

// for statement
for (i <- list; j <- list) yield 10*i+j  // i,j入れ子,list直接
for (i <- 1 to 3; j <- 1 to 3) yield 10*i+j  // i,j入れ子
for (i <- 1 to 3; j <- 1 to 3 if i != j) yield 10*i+j  // ifで条件指定


Int.MaxValue

object Main extends App {
  // ここをmain関数内として扱ってくれる
}
