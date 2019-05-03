public class Problem12 {
    public static void main(String[] args) {
        char [][] matrix = {{'a','b','t','g'},
                            {'c','f','c','s'},
                            {'j','d','e','h'}
                           };
        String str = "bfce";
        System.out.println(new Problem12().hasPath(matrix,str));
    }
    boolean hasPath(char [][] matrix,String str){
        if(matrix==null||matrix.length<1||matrix[0].length<1||str==null) return false;
        boolean [][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(hasPath(matrix,str,0,i,j,visited)) return true;
            }
        }
        return false;
    }
    boolean hasPath(char [][] matrix,String str,int path,int row,int col,boolean[][] visited){
        if(path==str.length()-1) return true;
        boolean haspath = false;
        if(row>=0&&row<matrix.length&&col>=0&&col<matrix[0].length&&matrix[row][col]==str.charAt(path)&&!visited[row][col]){
            visited[row][col] = true;
            haspath = hasPath(matrix,str,path+1,row+1,col,visited)||
                    hasPath(matrix,str,path+1,row-1,col,visited)||
                    hasPath(matrix,str,path+1,row,col+1,visited)||
                    hasPath(matrix,str,path+1,row,col-1,visited);
        }
        if(!haspath){
            path--;
            visited[row][col] = false;
        }
        return haspath;
    }
}