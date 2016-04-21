// O(V^3)
// V は頂点数
val d = Array.ofDim[Int](v, v)  // d[a][b] は辺 e = (a, b) のコスト(存在しない場合はINF, ただし d[i][i] = 0 とする)
val MAX = 1e9.toInt

// 初期化
for(i <- 0 until v; j <- 0 until v){
  if(i == j)
    d(i)(j) = 0
  else
    d(i)(j) = MAX
}

// ここで d の入力行う

// function
def warshall_floyd() =
  for(k <- 0 until v; i <- 0 until v; j <- 0 until v){
    d(i)(j) = Math.min(d(i)(j), d(i)(k) + d(k)(j))
  }
