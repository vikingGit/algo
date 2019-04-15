package xieed.explore.datastruct.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircularQueueTest {

    @Test
    public void should_success_when_enqueue_given_empty_circular_queue(){
        CircularQueue circularQueue = new CircularQueue<Integer>(4);
        circularQueue.enqueue(5);

        assertEquals(5, circularQueue.getArray()[0]);

//        1,2,3
//          2,3
//          4 --> 1
    }

    @Test
    public void should_success_when_dequeue_given_none_empty_circular_queue(){
        CircularQueue circularQueue = new CircularQueue<Integer>(4);
        circularQueue.enqueue(5);
        circularQueue.enqueue(4);

        assertEquals(5, circularQueue.dequeue());
    }


    @Test
    public void should_success_when_enqueue_given_unfull__circular_queue(){
        CircularQueue circularQueue = new CircularQueue<Integer>(4);
        circularQueue.enqueue(4);
        circularQueue.enqueue(3);
        circularQueue.enqueue(2);

        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.enqueue(5);
        circularQueue.enqueue(6);

        assertEquals(5, circularQueue.getArray()[3]);
        assertEquals(6, circularQueue.getArray()[0]);
    }

    @Test
    public void should_return_false_when_enqueue_given_full_circular_queue(){
        CircularQueue circularQueue = new CircularQueue<Integer>(4);
        circularQueue.enqueue(4);
        circularQueue.enqueue(3);
        circularQueue.enqueue(2);

        assertEquals(false, circularQueue.enqueue(5));
    }


    @Test
    public void should_return_null_when_dequeue_given_empty_circular_queue(){
        CircularQueue circularQueue = new CircularQueue<Integer>(4);
        circularQueue.enqueue(4);
        circularQueue.enqueue(3);

        assertEquals(4, circularQueue.dequeue());
        assertEquals(3, circularQueue.dequeue());
        assertEquals(null, circularQueue.dequeue());
    }



}