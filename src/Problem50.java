import java.util.LinkedList;
import java.util.Queue;
public class Solution {
    int [] character = new int[256];
    Queue<Character> queue = new LinkedList<Character>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        character[ch]++;
        queue.offer(ch);
        while(!queue.isEmpty()&&character[queue.peek()]>1){
            queue.poll();
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if(queue.isEmpty()) return '#';
        return queue.peek();
    }
}