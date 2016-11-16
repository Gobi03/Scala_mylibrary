val break = new scala.util.control.Breaks
break.breakable {
  while(true) {
    break.break
  }
}
