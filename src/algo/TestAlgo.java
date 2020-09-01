package algo;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class TestAlgo {

    @Test
    public void test1(){
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(3);
        stack.push(2);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("size:"+stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }

    /**
     * 用队列实现栈
     */
    class MyStack {

        Queue<Integer> queue;

        public MyStack(){
            queue = new LinkedList<>();
        }

        public void push(int item){
            queue.offer(item);
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop(){
            return queue.poll();
        }

        public int size(){
            return queue.size();
        }

        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }
}
