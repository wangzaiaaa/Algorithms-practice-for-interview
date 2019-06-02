public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length<1) return 0;
        int cur = 0,max = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(cur<=0){
                cur = array[i];
            }else{
                cur += array[i];
                
            }
            if(cur>max) max = cur;
        }
        return max;
    }
}