/**
 * 题目一: 找出数组中重复的数字
 *
 */
public class Probem1 {
    public static void main(String [] args){
        int [] test = {0,1,2,3,4,4};
        System.out.println(duplicate(test));
    }
    public static boolean duplicate(int [] nums){
        if(nums==null||nums.length<1) return false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=nums.length||nums[i]<0) return false;
        }
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]])return true;
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return false;
    }
}
