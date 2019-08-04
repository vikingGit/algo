package xieed.algorithm.BackTrack;

import org.junit.Test;

import static org.junit.Assert.*;

public class YangHuiTriangulationTest {

    @Test
    public void calculateTriangulationPath() {
        int[][] triangulation = new int[][]{{5},{7,8},{2,3,4},{4,9,6,1},{2,7,9,4,5}};
        YangHuiTriangulation yhTriangulation = new YangHuiTriangulation(triangulation);
        System.out.println("min path value:"+ yhTriangulation.calculateTriangulationPath());
    }
}