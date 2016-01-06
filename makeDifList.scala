def makeDifList(l: List[Int]): List[Int] = {
  l match{
    case x :: Nil => Nil
    case x :: y :: l2 => (y-x) :: makeDifList(y :: l2)
    case Nil => throw new Exception("error")
  }
}
