object RollingHash {

  // a は bに含まれているか
  // 失敗し得る
  def contain(a: String, b: String): Boolean = {
    val B = 5570293
    val h = 1e9.toLong

    val al = a.length; val bl = b.length
    if (al > bl)
      return false

    // B の al 乗を計算
    var t = 1L
    for (_ <- 1 to al) {
      t *= B
      t %= h
    }

    // aとbの最初のal文字に関するハッシュ値を計算
    var ah = 0L; var bh = 0L
    for (i <- 0 until al)
      ah = (ah * B + a(i).toLong) % h
    for (i <- 0 until al)
      bh = (bh * B + b(i).toLong) % h

    // bの場所を1つずつ進めながらハッシュ値をチェック
    for (i <- 0 to bl-al) { // ここで実際に一致するかも確認すると確定で成功する
      if (ah == bh)
        return true
      if (i + al < bl) {
        bh *= B
        bh %= h
        bh += b(i+al).toLong - b(i).toLong * t
        if(bh < 0)
          bh += h * 1000
        bh %= h
      }
    }

    false
  }

}
