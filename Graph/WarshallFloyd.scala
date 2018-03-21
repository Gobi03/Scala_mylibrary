// O(V^3)
// v は頂点数

// 他ノードを経由しているかの確認
// (i != x && i != y) && d(x)(y) == d(x)(i) + d(i)(y)


// d[a][b] は辺 e = (a, b) のコスト(存在しない場合はINF, ただし d[i][i] = 0 とする)
val d = Array.ofDim[Long](v+1, v+1)

// 初期化
val MAX = Long.MaxValue
for(i <- 1 to v; j <- 1 to v){
  if(i == j)
    d(i)(j) = 0
  else
    d(i)(j) = MAX
}

// ここで d の入力行う


// warshall_floyd
for(k <- 1 to v; i <- 1 to v; j <- 1 to v){
  d(i)(j) = Math.min(d(i)(j), d(i)(k) + d(k)(j))
}
