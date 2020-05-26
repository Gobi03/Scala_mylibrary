case class Point(x: Int, y: Int)

// 要テスト
// 線分 ab と線分 cd が交差するか
def judgeIentersected(ab: (Point, Point), cd: (Point, Point)): Boolean = {
    val (a, b) = ab; val (c, d) = cd

    val s1 = (a.x - b.x) * (c.y - a.y) + (a.y - b.y) * (a.x - c.x)
    val s2 = (a.x - b.x) * (d.y - a.y) + (a.y - b.y) * (a.x - d.x)
    val t1 = (c.x - d.x) * (a.y - c.y) + (c.y - d.y) * (c.x - a.x)
    val t2 = (c.x - d.x) * (b.y - c.y) + (c.y - d.y) * (c.x - b.x)

    s1 * s2 < 0 && t1 * t2 < 0
    // s1 * s2 <= 0 && t1 * t2 <= 0 // 端点を含む場合
}
