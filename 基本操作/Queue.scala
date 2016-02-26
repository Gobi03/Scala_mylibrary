val queue = new scala.collection.mutable.Queue[String]

// add an element
queue += "a"

// add multiple elements
queue ++= List("b", "c")

// dequeue
queue.dequeue
