class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1==null||s2==null||s1.length()>s2.length()) return false;
        int [] book1 = new int [26];
        int [] book2 = new int [26];
        for(int i=0;i<s1.length();i++){
            book1[s1.charAt(i)-'a']++;
            book2[s2.charAt(i)-'a']++;
        }
        if(check(book1,book2)) return true;
        int left = 0,right = s1.length();
        while(right<s2.length()){
            book2[s2.charAt(left++)-'a']--;
            book2[s2.charAt(right++)-'a']++;
            if(check(book1,book2)) return true;
        }
        return false;
    }
    public boolean check(int [] book1,int [] book2){
        for(int i=0;i<book1.length;i++){
            if(book1[i]!=book2[i]) return false;
        }
        return true;
    }
}