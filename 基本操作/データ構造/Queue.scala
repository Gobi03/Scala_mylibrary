val q = new scala.collection.mutable.Queue[Int]

// enqueue
q.enqueue(1)
q.enqueue(2)
q += 3

// dequeue
q.dequeue

// add List's elements
q ++= List(1, 2, 3)
