package com.queue;



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

}
