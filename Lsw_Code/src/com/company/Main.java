package com.company;

import java.util.Scanner;



//public class Main {
//
//    public static void main(String[] args) {
//
//        child p = new child();
//        p.method();
//        Scanner sc= new Scanner(System.in);
//
//        int t, n;
//        String str;
//        t= sc.nextInt();
//
//        for(int i=0;i<t;i++)
//        {
//            n= sc.nextInt();
//            str= sc.next();
//            String tmp="";
//
//            for(int j =0;j < str.length();j++)
//            {
//                for(int k=0;k<n;k++)
//                    tmp+=str.charAt(j); // java string은 이렇게 인덱스 접근 ok
//            }
//            System.out.println(tmp);
//        }
//
//    }
//}

//// 상속 설명 코드
//interface Animal{
//     void sleep();
//     void crawling();
//
//}
//class Dog implements Animal{
//    public void sleep() {
//
//    }
//
//    @Override
//    public void crawling(){
//        System.out.println("왈왈~");
//    }
//}
//class Cat implements Animal{
//
//    public void sleep() {
//
//    }
//    public void crawling(){
//        System.out.println("야옹~");
//    }
//}
//
//public class Main{
//    public static void main(String[] args) {
//        Cat c = new Cat(); //인스탄스 생성
//        Dog d = new Dog();
//
//        d.crawling();
//        c.crawling();
//    }
//}
/*
* 설명할 것~
* 1. 클래스와 인스턴스
* 2. 호출 스택
* 3. 클래스 static 메소드 & 인스턴스 메소드
* 4. 참조형 반환 타입
*  */

// // TV 관련 부분으로 설명 할 생각 클래스와 인스턴스
//class TV{
//    // 속성
//    String color;
//    boolean power;
//    int channel;
//
//    //기능들
//    void powerOn() {
//        power= true;
//    }
//    void power(){ power =!power;}
//    void channelUP(){++channel;}
//    void channelDown(){--channel;}
//}
//
//public class Main{
//
//    public static void main(String[] args) {
//        TV t = new TV();
//
//        t.powerOn();
//        System.out.println("hello~~");
//    }
//}

// what is static 클래스 영역 과 인스턴스 영역
//
//class Method{
//    int instancevariable;
//    static int classvariabel;
//
//    void instanceMethod(){
//        System.out.println("instance 함수입니다~");
//    }
//
//    static void classMethod() {
//        System.out.println("class 함수입니다.");
//    }
//}
//public class Main{
//
//    public static void main(String[] args) {
//        Method m = new Method();
//
//        m.instanceMethod();
//
//        Method.classMethod();
//
//    }
//}


// 참조형 관련 예제
class Data{
    int val;
}
public class Main {
    protected void pro()
    {
        System.out.println("yes");
        Data d= new Data(); // default
    }

    public void pub() {
        System.out.println("pub");
    }
    static void change1(int x)
    {
        x = 20;
    }
    static void change2(Data d)
    {
        d.val = 20;
    }
    static Data newData(Data d)
    {
        Data tmp =new Data();
        tmp.val=30;
        return tmp;
    }

//    public static void main(String[] args) {
//        Data d = new Data();
//        d.val =10;
//
//        change1(d.val);
//
//        change2(d);
//
//    }
}
//interface Car{
//    void move();
//    void stop();
//}
//class K3 implements Car{
//    @Override
//    public void move()
//    {
//        System.out.println("go k3");
//    }
//    @Override
//    public void stop()
//    {
//        System.out.println("stop k3");
//    }
//}
//
//class Tesla implements Car{
//    @Override
//    public void move()
//    {
//        System.out.println("go Tesla");
//    }
//    @Override
//    public void stop()
//    {
//        System.out.println("stop Tesla");
//    }
//}

class parent{
    int x = 2;
}
class child extends parent{
    int x= 5;

    void method() {
        super.x = 6;
        System.out.println("x ?= " + x);
    }

}
class Tv {
    boolean power;
    int channel;

    void power()       {   power = !power; }
    void channelUp()   {   ++channel;      }
    void channelDown() {   --channel;      }
}

class SmartTv extends Tv {
    boolean caption;
        void displayCaption(String text) {
        if (caption) {
            System.out.println(text);
        }
    }
}


//class Main {
//    public static void main(String args[]) {
//
//        SmartTv stv = new SmartTv();
//        stv.channel = 10;
//        stv.channelUp();
//        System.out.println(stv.channel);
//        stv.displayCaption("Hello, World");
//        stv.caption = true;
//        stv.displayCaption("Hello, World");
//    }
//}


//// 생성자 내용 설명할 때, 오버라이딩
//public class Main {
//    public static void main(String[] args) {
//
//        Point3D p = new Point3D(1, 2, 3);
//        System.out.println("x=" + p.x + ",y=" + p.y + ",z=" + p.z);
//    }
//}

class Point {
    int x, y;
    Point(){

    }
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Point3D extends Point {
    int z;

    Point3D(int x, int y, int z) {
        super(x, y); 
        this.z = z;
    }
}