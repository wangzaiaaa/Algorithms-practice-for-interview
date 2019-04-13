//替换空格
public class Problem5 {
    public static String replaceSpace(String target){
        if(target==null||target.length()<1) return null;
        int countOfSpace = 0,ansLen=0;
        for(int i=0;i<target.length();i++){
            if(target.charAt(i)==' ') countOfSpace++;
        }
        ansLen  = target.length() + 2 * countOfSpace;
        char [] answer = new char[ansLen];
        int p1 = target.length()-1,p2 = answer.length-1;
        while(p1>=0&&p2>=p1){
            if(target.charAt(p1)!=' ') answer[p2--] = target.charAt(p1--);
            else {
                p1--;
                answer[p2--]='0';
                answer[p2--]='2';
                answer[p2--]='%';
            }
        }
        return String.valueOf(answer);
    }

    public static String mySolution(String target){
        if(target==null||target.length()<1) return "";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<target.length();i++){
            if(target.charAt(i)!=' ')sb.append(target.charAt(i));
            else sb.append("%20");
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String test = "We are happy";
        System.out.println(replaceSpace(test));
        System.out.println(mySolution(test));

    }
}
