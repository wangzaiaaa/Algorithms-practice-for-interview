
//ì³²¨À­ÆõÊıÁĞ
public class Problem10 {
    public long solution1(int n){
        if(n<=0) return 0;
        else if(n==1) return 1;
        else return solution1(n-1) + solution1(n-2);
    }
    public long solution2(int n){
        if(n<=0) return 0;
        long temp1 = 0,temp2 = 1,ans = 0;
        for(int i=2;i<=n;i++){
            ans = temp1 + temp2;
            temp1 = temp2;
            temp2 = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        long ans1 = new Problem11().solution1(45);
        long end1 = System.currentTimeMillis();
        System.out.println("solution1 cost " + (end1-start1) +" and the answer is " + ans1);
        long start2 = System.currentTimeMillis();
        long ans2 = new Problem11().solution2(45);
        long end2 = System.currentTimeMillis();
        System.out.println("solution2 cost " + (end2-start2) +" and the answer is " + ans2);

    }
}