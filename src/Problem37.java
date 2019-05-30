import java.util.Collections;
import java.util.ArrayList;
public class Solution {
    public ArrayList<String> Permutation(String str) {
       ArrayList<String> ans = new ArrayList<>();
       if(str==null||str.length()<1)return ans;
        Permutation(str.toCharArray(),ans,0);
        Collections.sort(ans);
        return ans;
        
    }
    public void Permutation(char [] str,ArrayList<String> list,int index){
        if(index==str.length-1){
            if(!list.contains(String.valueOf(str))){
                list.add(String.valueOf(str));
            }
        }else{
            for(int i=index;i<str.length;i++){
                swapCharacter(str,index,i);
                Permutation(str,list,index+1);
                swapCharacter(str,index,i);
            }
        }
    }
    public void swapCharacter(char [] str,int i,int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}