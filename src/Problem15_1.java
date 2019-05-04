public class Problem15 {
    public static void main(String[] args) {
        System.out.println(new Problem15().countOfOne(5));
      
    }
    //可能发生死循环
//    int countOfOne(int num){
//        int count = 0;
//        for(int i=0;i<32;i++){
//            count += (num >> i) & 1;
//        }
//        return count;
//    }
    
    int countOfOne(int num){
        int count = 0;
        int flag = 1;
        for(int i=0;i<32;i++){
            if((num & flag) !=0) count++;
            flag = flag << 1;
        }
        return count;
    }
    int countOfOne1(int num){
        int count = 0;
        while (num != 0){
            count++;
            num = num & (num-1);
        }
        return count;
    }
}