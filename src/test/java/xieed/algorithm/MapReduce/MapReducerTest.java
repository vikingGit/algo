package xieed.algorithm.MapReduce;

import org.junit.Test;

import static org.junit.Assert.*;

public class MapReducerTest {

    @Test
    public void should_return_correct_reversePair_when_countReversePair() {
        assertEquals(3, new MapReducer().countReversePair(new int[]{4, 2, 6, 3}, 0, 3));
        assertEquals(4, new MapReducer().countReversePair(new int[]{4, 2, 6, 3, 5}, 0, 4));
        assertEquals(9, new MapReducer().countReversePair(new int[]{4, 2, 6, 3, 5,1}, 0, 5));
    }
}