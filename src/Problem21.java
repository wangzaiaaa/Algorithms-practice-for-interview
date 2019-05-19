/**
 * @author bonsoirzw
 * @date 2019/5/19
 * 调整数组顺序使奇数位于偶数前
 */
public class Problem21 {
    public static void main(String[] args) {
        Problem21 problem21 = new Problem21();
        int [] array = {1,2,3,4,5};
        for(int i:array){
            System.out.print(i+" ");
        }
        problem21.Reorder(array);
        for(int i:array){
            System.out.print(i+" ");
        }
    }
    public void Reorder(int [] nums){
        if(nums==null||nums.length<1){
            return;
        }else{
            int start = 0,end = nums.length-1;
            while (start < end){
                while (start < end && !isEvent(nums[start])){
                    start++;
                }
                while (end > start && isEvent(nums[end])){
                    end--;
                }
                if(start < end){
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                }
            }
        }
    }
    public boolean isEvent(int n){
        return (n & 1) == 0;
    }

}