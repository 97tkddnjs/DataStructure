package com.stack;

import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class IntStack {
    private int max;
    private int ptr;    //새로 삽입할 데이터의 위치를 의미함
    private int[] stk;

    // runtime error 스택이 비어있음
    public class EmptyIntStackException extends  RuntimeException{
        public EmptyIntStackException(){
            super("Empty Stack");
        }
    }

    // 스택이 가득참
    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException() {
            super("Stack is Full");
        }
    }

    //Constructor
    public IntStack(int capacity) {
        ptr =0;
        max = capacity;
        try{
            stk = new int[max];
        }catch (OutOfMemoryError e){ //생성이 불가능한 것
            System.out.println("베열 생성이 불가합니다.");
            max=0;
        }
    }
    // 스택에 데이터를 넣는다.
    public int push(int x) throws OverflowIntStackException{
        if (ptr >= max) { // 스택이 가득찬 것을 의미한다.
            throw  new OverflowIntStackException();
        }
        return stk[ptr++] = x;
    }
    // 스택에서 데이터를 pop 정상에 있는 데이터를 꺼냄
    public int pop() throws EmptyIntStackException{
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[--ptr];
    }
    // 스택에서 데이터를 peek
    public int peek() throws  EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[ptr-1];
    }

    public int capacity(){
        return max;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        if(ptr<=0)
            return false;
        else
            return true;
    }
    public boolean isFull() {
        if(ptr >= max)
            return true;
        return false;
    }
    // stack 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump() {
        if (ptr <= 0) {
            System.out.println("stack이 비어있습니다");
        }
        else{
            for(int i=0;i<ptr;i++)
                System.out.print(stk[i]+" ");
            System.out.println();
        }
    }

}

class Main {
    public static void main(String[] args) {
        IntStack st = new IntStack(5);

        Stack<Integer> stack = new Stack<>();

        // push
        stack.push(3);
        // stack의 크기 출력
        stack.size();
        // stack이 비어있는지 check (비어있다면 true)
        stack.empty();
        // stack에 1이 있는지 check (있다면 true)
        stack.contains(1);


        for (int i = 0; i < 8; i++) { //일부러 에러 내본 것임
            st.push(i);
        }

    }
}