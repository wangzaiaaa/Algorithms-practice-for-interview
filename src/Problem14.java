public class Problem14 {
    public static void main(String[] args) {
        System.out.println(new Problem14().MaxProductAfterCutting(8));
        System.out.println(new Problem14().MaxProductAfterCutting1(8));
    }

    int MaxProductAfterCutting(int length){
        if(length<2) return 0;
        else if(length==2) return 1; //最少切一次
        else if(length==3) return 2;
        int [] dp = new int [length+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4;i<=length;i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (dp[j] * dp[i - j] > max) max = dp[j] * dp[i - j];
            }
            dp[i] = max;
        }
        return dp[length];
    }
    int MaxProductAfterCutting1(int length){
        if(length<2) return 0;
        else if(length==2) return 1;
        else if(length==3) return 2;
        int timeOf3 = length / 3;
        if (length - timeOf3 * 3 == 1)timeOf3--;
        int timeOf2 = (length - timeOf3 * 3)/2;
        return (int)Math.pow(3,timeOf3) * (int)Math.pow(2,timeOf2);
    }

}