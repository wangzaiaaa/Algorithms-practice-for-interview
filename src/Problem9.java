


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem9 {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        for(int i=0;i<10;i++){
            queue.offer(i);
        }
        while (!queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }
        MyStack<Integer> satck = new MyStack<>();
        for(int i=0;i<10;i++){
            satck.push(i);
        }
        while (!satck.isEmpty()){
            System.out.print(satck.pop()+" ");
        }
    }
}
class MyQueue<T>{
    private Stack<T> curent;
    private Stack<T> assist;
    public MyQueue(){
        this.curent = new Stack<>();
        this.assist = new Stack<>();
    }
    public boolean isEmpty(){
        return this.curent.isEmpty()&&this.assist.isEmpty();
    }
    public int size(){
        return Math.max(this.assist.size(),this.curent.size());
    }
    public void offer(T val){
        while (!this.assist.isEmpty()){
            this.curent.push(this.assist.pop());
        }
        this.curent.push(val);
    }
    public T poll(){
        while (!this.curent.isEmpty()){
            this.assist.push(this.curent.pop());
        }
        if(this.assist.isEmpty()) throw new IllegalArgumentException("this queue is empty");
        return this.assist.pop();
    }
}
class MyStack<T>{
    private Queue<T> queue1,queue2;
    public MyStack(){
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }
    public boolean isEmpty(){
        return this.queue1.isEmpty()&&this.queue2.isEmpty();
    }
    public void push(T val){
        if(this.queue2.isEmpty()) this.queue1.offer(val);
        else this.queue2.offer(val);
    }
    public T pop(){
        if(isEmpty()) throw new IllegalArgumentException("thw stack is empty");
        T target = null;
        if(this.queue1.isEmpty()){
            while (this.queue2.size()>1){
                this.queue1.offer(this.queue2.poll());
            }
            target = this.queue2.poll();
        }else if(this.queue2.isEmpty()){
            while (this.queue1.size()>1){
                this.queue2.offer(this.queue1.poll());
            }
            target =  this.queue1.poll();
        }
        return target;

    }

}
