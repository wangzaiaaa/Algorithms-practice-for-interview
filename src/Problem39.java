public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length<1) return 0;
        int res = array[0];
        int times = 1;
        for(int i=1;i<array.length;i++){
            if(times==0){
                res = array[i];
                times = 1;
            }else if(array[i]==res){
                times++;
            }else{
                times--;
            }
        }
        if(check(array,res))return res;
        return 0;
    }
    public boolean check(int [] array,int target){
        int times = 0;
        for(int i:array){
            if(i==target) times++;
        }
        return 2 * times > array.length;
    }
}