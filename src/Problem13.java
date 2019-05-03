
//机器人的运动范围
public class Problem13 {
    int movingCountCore(int threshold,int row,int col,boolean [][] visited){
        if(threshold<0||visited.length<=0||visited[0].length<=0) return 0;
        int count = 0;
        if(check(threshold,row,col,visited.length,visited[0].length,visited)){
            visited[row][col] = true;
            count += movingCountCore(threshold,row+1,col,visited) +
                    movingCountCore(threshold,row-1,col,visited) +
                    movingCountCore(threshold,row,col+1,visited) +
                    movingCountCore(threshold,row,col-1,visited);
        }
        return count;
    }
    boolean check(int threshold,int row,int col,int rows,int cols,boolean [][] visited){
        if (row>=0&&row<=rows&&col>=0&&col<=cols&&(getDigitSum(row)+getDigitSum(col)<=threshold)&&!visited[row][col])
            return true;
        else
            return false;
    }
    int getDigitSum(int number){
        int sum = 0;
        while (number>0){
            sum += number%10;
            number /= 10;
        }
        return sum;
    }
}