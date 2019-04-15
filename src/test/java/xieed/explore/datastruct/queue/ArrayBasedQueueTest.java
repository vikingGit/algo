package xieed.explore.datastruct.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayBasedQueueTest {
    @Test
    public void should_add_new_element_when_enqueue_given_new_element(){
        ArrayBasedQueue queue = new ArrayBasedQueue(10);
        queue.enQueue(1);
        queue.enQueue(4);
        queue.enQueue(3);

        assertEquals(3, queue.capacity());
    }

    @Test
    public void should_extend_queue_when_enqueue_given_queue_is_full() {
        ArrayBasedQueue queue = new ArrayBasedQueue(3);
        queue.enQueue(3);
        queue.enQueue(2);
        queue.enQueue(6);
        queue.enQueue(8);

        assertEquals(6, queue.capacity());
    }

    @Test
    public void should_remove_element_when_dequeue_given_non_empty_queue() {
        ArrayBasedQueue queue = new ArrayBasedQueue(3);
        queue.enQueue(3);
        queue.enQueue(2);
        queue.enQueue(6);

        assertEquals(3, queue.deQueue());
        assertEquals(2, queue.size());
        assertEquals(3, queue.capacity());
    }

    @Test
    public void should_move_element_when_enqueue_given_full_queue_but_some_element_dequeued() {
        ArrayBasedQueue queue = new ArrayBasedQueue(4);
        queue.enQueue(3);
        queue.enQueue(2);
        queue.enQueue(6);
        queue.enQueue(7);

        queue.deQueue();
        queue.deQueue();

        queue.enQueue(8);
        assertEquals(3, queue.size());
        assertEquals(4,queue.capacity());
        assertEquals(6, queue.getArray()[0]);
        assertEquals(7, queue.getArray()[1]);
        assertEquals(8, queue.getArray()[2]);
        assertEquals(0, queue.head);
        assertEquals(3, queue.tail);
    }
}