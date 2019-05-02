


//旋转数组的最小值
public class Problem11 {
    public static void main(String[] args) {
        int [] array = {3,4,5,1,2};
        int num = new Problem11().findMinElement(array);
        System.out.println(num);
    }
    int findMinElement(int [] array){
        if (array==null||array.length<1) throw new IllegalArgumentException("Invalid parameters");
        int index1 = 0,index2 = array.length - 1;
        int midIndex = index1;
        while (array[index1] >= array[index2]){
            if(index2 == index1 +1){
                midIndex = index2;
                break;
            }
            midIndex = index1 + ((index2-index1)>>1);
            if(array[midIndex] == array[index1]&&array[index2]==array[index1]) return findMinElement(array,index1,index2);
            if(array[midIndex] >= array[index1]) index1 = midIndex;
            else if(array[midIndex] <= array[index2]) index2 = midIndex;
        }
        return array[midIndex];
    }
    int findMinElement(int [] array,int start,int end){
        if(array==null||start<0||end>=array.length) throw new IllegalArgumentException("wrong arguement");
        int max = array[start];
        for(int i=start+1;i<=end;i++){
            if(array[i]>max) max = array[i];
        }
        return max;
    }
}