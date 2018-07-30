import scala.collection.mutable.Queue

val q = new Queue[Int]

// enqueue
q.enqueue(1)
q.enqueue(2)
q += 3

// dequeue
q.dequeue

// add List's elements
q ++= List(1, 2, 3)

q.isEmpty
