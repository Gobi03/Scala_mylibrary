import scala.collection.mutable.Set

scala> val set = Set(2, 7, 1, 8, 2, 8)
set: scala.collection.mutable.Set[Int] = Set(2, 7, 1, 8)


set1 += 42   // 要素の追加
set1(42) // 要素の存在確認

set1.intersect(set2)  // set1とset2の積集合求める
set1.union(set2)    // set1とset2の和集合求める
set1.diff(set2)    // set1とset2の差集合求める
set1.subsetOf(set2) :Boolean  // set1がset2の部分集合かどうかを求める

toList , toSeq
toSet
