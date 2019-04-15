package xieed.algorithm;

import static org.junit.Assert.*;

import org.junit.Test;
import xieed.algorithm.Recursion.Referee;

public class RecursionTest {

  @Test
  public void should_return_5_when_caculateWaysOfClimbingStairs_given_totally_4_steps() {
    assertEquals(5, new Recursion().caculateWaysOfClimbingStairs(4));
  }

  @Test
  public void should_return_5_when_caculateWaysOfClimbingStairs_given_totally_7_steps() {
    assertEquals(21, new Recursion().caculateWaysOfClimbingStairs(7));
  }

  @Test
  public void should_return_aa_when_getUltimateReferer_given_refrees(){
    Referee cc = new Recursion().new Referee("cc");
    Referee bb = new Recursion().new Referee("bb");
    Referee aa = new Recursion().new Referee("aa");
    cc.referer=bb;
    bb.referer=aa;

    assertEquals("aa", new Recursion().getUltimateReferer(cc, "cc"));
    assertNull(new Recursion().getUltimateReferer(cc, "aa"));
  }
}