public class Problem2 {
    //长度为n+1的数组，有n个数字，找出重复的那个
    public static int count(int [] array,int start,int end){
        int count = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]>=start&&array[i]<=end) count++;
        }
        return count;
    }
    public static int findNum(int [] array){
        if(array==null||array.length<1) return -1;
        int start = 1,end = array.length-1;
        while (end>=start){
            int mid = ((end-start)>>1) + start;
            int cou = count(array,start,mid);
            if(end==start){
                if(cou>1) return end;
                break;
            }
            if(cou>mid-start+1) end = mid;
            else start = mid+1;
        }
        return -1;
    }
    public static void main(String [] args){
        int a [] = {1,2,3,4,2};
        System.out.println(findNum(a));
    }
}
