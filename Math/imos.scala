// 区間[a, b]について
// n : 区間数, m : データ数
// 条件に応じて i の始点終点に気をつける

var imos = new Array[Int](n+2)

for(i <- 0 to m-1){
  imos(l(i)) += 1
  imos(r(i)+1) -= 1
}

for(i <- 0 to n-1){
  imos(i+1) += imos(i)
}
