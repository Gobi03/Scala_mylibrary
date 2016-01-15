// reference : http://qiita.com/tanigon/items/96f45b3dcdd15b04cc89

import scala.util.control.Breaks

val b = new Breaks  // instance of Breaks

// インスタンスを明示したbreakの書き方
b.breakable {
  for (x <- 1 to 100) {
    println(x)
    if (x == 50) b.break
  }
}

// もっと簡潔な表現
import b.{breakable,break}

breakable {
  ....
  break
}

// 脱出するbreakableは明示によって外側のものも選べる
val b1 = new Breaks
val b2 = new Breaks

b1.breakable {
  for (x <- 1 to 100) {
    b2.breakable {
      for (y <- 1 to 100) {
        println(y)
        if (y == 10) b1.break
      }
    }
  }
}
