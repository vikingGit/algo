package xieed.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringMatcherTest {

    @Test
    public void should_return_2_when_bruteForce_given_master_can_match_pattern_String() {
        StringMatcher stringMatcher = new StringMatcher();
        assertEquals(2, stringMatcher.BruteForce("sweirwei", "ei"));
    }

    @Test
    public void should_return_negative_1_when_bruteForce_given_master_cant_match_pattern_String() {
        StringMatcher stringMatcher = new StringMatcher();
        assertEquals(-1, stringMatcher.BruteForce("sweirwei", "eie"));
    }

    @Test
    public void should_return_759_when_hashOver26Decimal_given_ace(){
        StringMatcher stringMatcher = new StringMatcher();
        assertEquals(759, stringMatcher.hashOver26Decimal("ace"));
    }

    @Test
    public void should_return_hash_array_when_hashSubStrs_given_aceqf_with_length_of_3(){
        StringMatcher stringMatcher = new StringMatcher();
        int[] hashs = stringMatcher.hashSubStrs("aceqf", 5, 3);
        assertArrayEquals(new int[]{759,2175,3828}, hashs);
    }

    @Test
    public void should_return_2_when_findSubString_by_rabinKarp_given_acdqf() {
        StringMatcher stringMatcher = new StringMatcher();
        assertEquals(1, stringMatcher.RabinKarp("aceqf", "ceq"));
    }
}