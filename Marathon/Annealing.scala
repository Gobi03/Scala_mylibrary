// cf. http://shindannin.hatenadiary.com/entry/20121224/1356364040
val startTime = new Date().getTime // プログラムの開始時刻
val endTime = ??? // プログラム全体の実行時間

var currentScore = ???
var bestAns = ???
var bestScore =  currentScore

val annStartTime = new Date().getTime
var currentTime = annStartTime
val T = endTime - annStartTime // 焼きなましにかける時間
val R = 10000L

while ((currentTime - startTime) < endTime) {
  for (_ <- 1 to 100) {
    val t = currentTime - annStartTime // 焼きなまし法開始からの時間

    /** 線形温度関数 */
    // スコアが悪くなったときでも、次の状態に移動する遷移する場合はtrue。
    val ForceNext = T * Random.nextInt(R) < (T-t) * R // １次関数

    /** exp温度関数 */
    val startTemp = 100.0 // 数値は例。考えられるスコアの最大値を入れると良さそう。
    val endTemp = 10.0 // 数値は例。考えられるスコアの最小値を入れると良さそう。
    val temp = startTemp - ((startTemp - endTemp) * t / T)
    // 最大化なので、分子はnextScore - currentScoreで良い
    // temp は exp の外で割る方が良い説もある
    val probability = Math.exp((nextScore - currentScore) / temp)
    val ForceNext = probability > Random.nextDouble()


    // 遷移を実施

    val nextScore = calcScore() // 遷移後のスコアを計算

    if (nextScore > currentScore || ForceNext) {
      // 遷移を適用
    }
    else {
      // 遷移を破棄
    }

    // ベストスコアを保存
    if (currentScore > bestScore) {
      bestScore = currentScore
      bestAns = ??? // 現在の盤面を渡す
    }
  }

  currentTime = new Date().getTime
}
