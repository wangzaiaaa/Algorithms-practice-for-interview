/**
 * @author bonsoirzw
 * @date 2019/5/23
 * 顺时针打印矩阵
 */
public class Problem29 {
    void PrintMatrixInCircle(int [][] matrix,int start){
        int row = matrix.length;
        int column = matrix[0].length;
        int endX = column - 1 - start;
        int endY = row - 1 - start;
        /*
        从左到右打印一行
         */
        for(int i=start;i<=endX;i++){
            System.out.print(matrix[start][i]+" ");
        }
        /*
        从上到下打印一行
         */
        if(start<endY){
            for(int i=start+1;i<=endY;i++){
                System.out.print(matrix[i][endX]+" ");
            }
        }
        /*
        从右到左打印一行
         */
        if(start<endX&&start<endY){
            for(int i=endX-1;i>=start;i--){
                System.out.print(matrix[endY][i]+" ");
            }
        }
        /*
        从下到上打印一行
         */
        if(start<endX&&start<endY-1){
            for(int i=endY-1;i>=start+1;i--){
                System.out.print(matrix[i][start]+" ");
            }
        }
    }
    void PrintMatrixClockwisely(int [][] matrix){
        if(matrix==null||matrix.length<1||matrix[0].length<1) {
            return;
        }else{
            int row = matrix.length;
            int column = matrix[0].length;
            int start = 0;
            while (column>2*start&&row>=2*start){
                PrintMatrixInCircle(matrix,start);
                start++;
            }
        }
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3,4},
                           {5,6,7,8},
                           {9,10,11,12},
                           {13,14,15,16},
                          };
        new Problem29().PrintMatrixClockwisely(matrix);
    }
}
