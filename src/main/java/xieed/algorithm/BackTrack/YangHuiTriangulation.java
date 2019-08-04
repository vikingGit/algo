package xieed.algorithm.BackTrack;

public class YangHuiTriangulation {

    int[][] triangulation ;

    public YangHuiTriangulation(int[][] triangulation) {
        this.triangulation = triangulation;
    }

    public int calculateTriangulationPath(){
        int[][] aggregate = new int[5][5];

        aggregate[0][0] = triangulation[0][0];

        for(int i= 1; i < triangulation.length; i++){
            for(int j =0; j<triangulation[i].length; j++){
                if(j == 0){
                    aggregate[i][0] = aggregate[i-1][0] + triangulation[i][0];
                }else if(j == triangulation[i].length - 1){
                    aggregate[i][j] = aggregate[i-1][j-1] + triangulation[i][j];
                }else{
                    aggregate[i][j] = Math.min(aggregate[i-1][j-1], aggregate[i-1][j]) + triangulation[i][j];
                }
            }
        }

        int minPath = aggregate[4][0];
        for(int i = 1; i < 5; i++){
           if(aggregate[4][i] < minPath){
               minPath = aggregate[4][i];
           }
        }

        return minPath;
    }
}
