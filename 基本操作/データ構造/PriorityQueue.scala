import scala.collection.mutable.PriorityQueue

/*  降順  */
val pq = new PriorityQueue[Int]

// enqueue
pq += 21
pq.enqueue(13)

// reference the top element
pq.head

// dequeue
pq.dequeue

// check empty
pq.isEmpty


/*  昇順  */
val pq = new PriorityQueue[Int]()(Ordering.Int.reverse)
