//正则表达式匹配
public class Problem19 {
    public static void main(String[] args) {

    }


//    boolean match(String str,String patten,int i,int j){
////        if(str==null||patten==null) return false;
////        while (i<str.length()&&j<patten.length()){
////            char c1 = str.charAt(i),c2 = patten.charAt(j);
////            if(j+1<patten.length()&&patten.charAt(j+1)=='*'){
////                if(c1!=c2){
////                    i++;
////                    j += 2;
////                }else{
////                    while (i<str.length()&&str.charAt(i)==c2){
////                        i++;
////                    }
////                    j += 2;
////                }
////            }
////            if(c1==c2||c2=='.'){
////                i++;
////                j++;
////            }else{
////                return false;
////            }
////        }
////        if(i==str.length()&&j== patten.length()) return true;
////        return false;
////    }
    boolean match(String str,String pattern,int i,int j){
        if(str==null||pattern==null) return false;
        if(i==str.length()||j==pattern.length()) return false;
        if(j+1<pattern.length()&&pattern.charAt(j+1)=='*'){
            if(str.charAt(i)==pattern.charAt(j)||(pattern.charAt(j)=='.'&&i<str.length())){
                return match(str,pattern,i+1,j+2)||match(str,pattern,i+1,j)||match(str,pattern,i,j+2);
            }else{
                return match(str,pattern,i,j+2);
            }
        }
        if(str.charAt(i)==pattern.charAt(j)||(pattern.charAt(j)=='.'&&i<str.length()))
            return match(str,pattern,i+1,j+1);
        return false;
    }

}