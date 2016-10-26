val b = new scala.util.control.Breaks
b.breakable {
  while(true) {
    b.break
  }
}
