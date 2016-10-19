/* mutable ver */
import scala.collection.mutable.Map

// declaration
val map = Map("hamlet"-> 118, "ophelia"->31)
val map = Map(("hamlet", 118), ("ophelia", 31))

// 要素の追加
+ , +=
map += ("horatio"-> 48)

// update
map("hamlet") += 1

// keyが含まれているかどうか
map.contains("hamlet") :Boolean

map("hamlet") :Int // 要素の取り出し
map.apply("hamlet") :Int // 要素の取り出し
// キーが登録されていない場合には，エラーとなる．NoSuchElementException

map.getOrElse("hamlet", 0) :Int  // 要素の取り出し(error時sndの値返す)

// キーの集合を求める
map.keys
=> res: Iterable[String] = Set(hamlet, ophelia, horatio)

map.size, map.kes.size  // keyの個数


// キーに対するフィルター(キー7文字以上のものだけを求めている例)
scala> map.filterKeys(_.length >= 7)
res: Map[String,Int] = Map(ophelia -> 31, horatio -> 48)

// マップに直接filterを適用する場合は， キーと値の対(後述のPair)を引数とする関数を与える． 以下は，値が40以上のものだけを求めている． なお，「 kv._2 」は対kvの2番目の要素(すなわち値)を取り出している． 
scala> map.filter(kv => kv._2 >= 40)
res: Map[String,Int] = Map(hamlet -> 118, horatio -> 48)

// あるいは case のパターンマッチを用いた無名関数を利用しても良い． ここで case のまわりは ( ) ではなく { } でくくられていることに注意．
scala> map.filter{ case (w,c) => c >= 40 }
res: Map[String,Int] = Map(hamlet -> 118, horatio -> 48)

// for でも同様の処理ができる．
scala> for (kv <- map; if kv._2 >= 40) yield kv
res: Map[String,Int] = Map(hamlet -> 118, horatio -> 48)
scala> for ((w,c) <- map; if c >= 40) yield (w,c)
res: Map[String,Int] = Map(hamlet -> 118, horatio -> 48)
