//二维数组中的查找
public class Problem4 {
    static int [][]  array= {{1,2,8,9},
                             {2,4,9,12},
                             {4,7,10,13},
                             {6,8,11,15}};

    public static void main(String[] args) {
        System.out.println(Find(array,3));
        System.out.println(Find(array,7));
    }
    static boolean Find(int [][] matrix,int target){
        boolean found = false;
        if(matrix!=null&&matrix.length>=0&&matrix[0].length>=0){
            int row = 0,column = matrix[0].length-1;
            while (column>=0&&row<matrix.length){
                if(matrix[row][column]==target){
                    found = true;
                    break;
                }else if(matrix[row][column]>target) column--;
                else row++;
            }
        }
        return found;
    }

}
