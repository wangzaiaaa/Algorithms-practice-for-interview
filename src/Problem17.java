public class Problem17 {
    public static void main(String[] args) {
        new Problem17().print1ToMaxOfNDigits2(3);
    }
    void print1ToMaxOfNDigits(int n){
        if(n <= 0) return;
        char [] number = new char[n];
        for(char c : number) c = '0';
        while (!increment(number)){
            printNum(number);
        }
    }
    boolean increment(char [] number){
        boolean isOverflow = false;
        int takeover = 0;
        for(int i = number.length - 1;i>=0;i--){
            int nSum = number[i] - '0' + takeover;
            if(i == number.length-1) nSum += 1;
            if(nSum == 10){
                if(i == 0){
                    isOverflow = true;
                    break;
                }else{
                    takeover = 1;
                    number[i] = '0';
                }
            }else{
                number[i] = (char)('0' + nSum);
                break;
            }
        }
        return isOverflow;
    }
    void print1ToMaxOfNDigits2(int n){
        if(n <= 0) return;
        char [] number = new char[n];
        Print1ToMaxOfNDigtsRecursively(number,0);
    }
    void Print1ToMaxOfNDigtsRecursively(char [] number,int index){
        if(index==number.length){
            printNum(number);
            return;
        }
        for(int i=0;i<10;i++){
            number[index] = (char)(i + '0');
            Print1ToMaxOfNDigtsRecursively(number,index + 1);
        }
    }
    void printNum(char [] number){
        boolean isBegin = true;
        for(int i=0;i<number.length;i++){
            if(isBegin&&number[i]!='0') isBegin = false;
            if(!isBegin){
                System.out.printf("%c",number[i]);
            }
        }
        System.out.printf("  ");
    }
}