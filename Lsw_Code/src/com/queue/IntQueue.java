package com.queue;


import java.util.LinkedList;
import java.util.Queue;

// 링 버퍼의 형태임
public class IntQueue {
    private int max;    // 큐의 용량
    private int front;  // 첫번째 요소 커서
    private int rear;
    private int num;
    private int[] que;

    // queue is empty
    public class EmptyQueueException extends RuntimeException {
        public EmptyQueueException(){
            super("Empty Queue");
        }
    }
    // queue is full
    public class OverflowQueueException extends RuntimeException{
        public OverflowQueueException() {
            super("Queue is Full");
        }
    }

    public IntQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;

        try{
            que = new int[max];
        }catch (OutOfMemoryError e){
            max = 0;
        }

    }
    public int enque(int x) throws OverflowQueueException{
        if(num>=max)
            throw new OverflowQueueException();
        que[++rear]=x;
        num++;
        if(rear == max)
            rear=0;
        return x;
    }

    public int deque() throws EmptyQueueException {
        if(num<=0)
            throw new EmptyQueueException();
        int x = que[front++];
        num--;
        if(front == max)
            front = 0;
        return x;
    }

    public int peek() throws EmptyQueueException {
        if(num<=0)
            throw new EmptyQueueException();
        return que[front];
    }

}
class Main {
    public static void main(String[] args) {
        IntQueue que = new IntQueue(5);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(2);     // queue에 값 2 추가
        queue.offer(3);   // queue에 값 3 추가
        queue.poll();       // queue에 첫번째 값을 반환하고 제거 비어있다면 null
        queue.remove();     // queue에 첫번째 값 제거
        queue.clear();      // queue 초기화
        queue.peek();       // queue의 첫번째 값 참조
    }
}