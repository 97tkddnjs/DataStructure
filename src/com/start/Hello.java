package com.start;
import com.company.Main;



//public class Hello extends Main{
//
//
////    public static void main(String[] args) {
////
////        Main m  = new Main();
////        Hello h  = new Hello();
////        h.pro(); //protected 사용 같은 클래스 X, 패키지 x, 자손 0
////
////        float f = 5-(float)(2.0)/4;
////       System.out.println("f = " + f);
////    }
//}

class Parent{
    int x = 10;
    void method() {
        System.out.println("Parent method");
    }
}

class Child extends Parent{

    int x = 20; // this.x

    void method() {
        System.out.println("Child method");
    }
}
class Point{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Point3D extends Point {
    int z;

    public Point3D(int x, int y, int z) {
        super(x, y); // 조상의 클래스의 생성자 Point를 호출
        this.z = z;
    }
}
class Card{
    final int num;
    final String kind;

    public Card(int num, String kind) {
        this.num = num;
        this.kind = kind;
    }
}
final class Singleton{
    private static Singleton s = new Singleton();

    private Singleton(){

    }
    public static Singleton getInstance() {
        if (s == null) {
            s = new Singleton();
        }
        return s;
    }
}

class SingltonTest {
    public static void main(String[] args) {
//      Singleton s = new Singleton(); //error!
        Singleton s1 = Singleton.getInstance();
    }
}
class Car{
    String color;
    int door;

    void drive() {
        System.out.println("drive~");
    }

    void stop() {
        System.out.println("stop");
    }
}

class FireEngine extends Car {
    void water() {
        System.out.println("water~");
    }
}

class Ambulance extends Car {
    void siren() {
        System.out.println("siren~");
    }
}

abstract class Player {     // 추상 클래스

    abstract void play();   //추상 메서드
    abstract void stop();   //추상 메서드
}
class AudioPlayer extends Player{
    void play(){
        /* contents no*/
    }
    void stop() {
        /* contents no*/
    }
}

abstract class AbstractPlayer extends Player {
    //일부 추상 메서드만 구현시 class 앞에 반드시 abstract 붙이기!
    void play(int pos){/* contents no*/ }
}

class Hello{
    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();
        car = fe;
//        car.water();
        fe2 = (FireEngine) car;
        fe2.water();

        Parent p = new Child();
        Child c = new Child();

        System.out.println("p.x = " + p.x);
        p.method();
        System.out.println("c.x = " + c.x);
        c.method();
        /*
        * *** result ***
        * p.x = 10
        * Child
        * c.x = 20
        * Child
        * */
    }
}
interface Fightable{
    void move(int x, int y);
    void attack();
}
class Fight implements Fightable{
    public void move(int x, int y){}
    public void attack(){}
}

class A{
    public void methodA(B b) {
        b.method();
    }
}
class B{
    public void method() {
        System.out.println("class B");
    }
}
//
//class Main{
//    public static void main(String[] args) {
//        Fightable f = new Fight();
//    }
//}