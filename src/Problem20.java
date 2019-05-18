/**
 * @author bonsoirzw
 * @date 2019/5/18
 * ��ʾ��ֵ���ַ���
 * ��ʾ��ֵ���ַ�����ѭģʽ A[.[B]][e|EC]����.B[e|EC]
 */
public class Problem20 {
    /**
     *
     * @param str �����ַ���
     * @param start ��ʼɨ�������λ��
     * @return end==start��ʾû��ɨ�赽һ���޷�����
     */
    int scanUnsignedInteger(String str,int start){
        int end = start;
        while(end>=0&&end<str.length()&&str.charAt(end)>='0'&&str.charAt(end)<='9'){
            end++;
        }
        return end;
    }
    /**
     *
     * @param str �����ַ���
     * @param start ��ʼɨ�������λ��
     * @return -1��ʾû��ɨ�赽һ������
     */
    int scanInteger(String str,int start){
        if(start>=str.length()||start<0){
            return start;
        }else if(str.charAt(start)=='+'||str.charAt(start)=='-'){
            start++;
        }
        return scanUnsignedInteger(str,start);
    }

    boolean match(String str,int index){
        if(str==null||index<0||str.length()<1) {
            return false;
        }
        int curIndex = scanInteger(str,index);
        boolean numberic = (curIndex != index);
        if(curIndex<str.length()&&str.charAt(curIndex)=='.'){
            curIndex++;
            numberic = numberic || scanUnsignedInteger(str,curIndex) != curIndex;
            curIndex = scanUnsignedInteger(str,curIndex);
        }
        if(curIndex<str.length()&&(str.charAt(curIndex)=='e'||str.charAt(curIndex)=='E')){
            curIndex++;
            numberic = numberic && scanInteger(str,curIndex)!=curIndex;
            curIndex = scanInteger(str,curIndex);
        }
        return numberic&&curIndex==str.length();
    }

    public static void main(String[] args) {
        String str1 = "12";
        String str2 = "1e2.5";
        String str3 = "1e2";
        String str4 = "+1.2e2";
        Problem20 P = new Problem20();
        System.out.println(P.match(str1,0));
        System.out.println(P.match(str2,0));
        System.out.println(P.match(str3,0));
        System.out.println(P.match(str4,0));
    }

}
