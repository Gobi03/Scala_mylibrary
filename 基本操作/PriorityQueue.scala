import scala.collection.mutable.PriorityQueue


/*  降順  */
val q = new PriorityQueue[Int]

// enqueue
q += 21
q.enqueue(13)

// reference the top element
q.head

// dequeue
q.dequeue

// check empty
q.isEmpty



/*  昇順  */
val q = new PriorityQueue[Int]()(Ordering.Int.reverse)
