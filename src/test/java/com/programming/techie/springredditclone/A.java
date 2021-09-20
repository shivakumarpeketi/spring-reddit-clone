package com.programming.techie.springredditclone;

import java.io.IOException;

class A {
    private static int i =0;
    private B b;
    String foo1()    {
//        foo2();
        b.fooB();
        System.out.println("Class A with foo1");
        return "RealString_1";
    }

    String foo2() {
        return "RealString_2";
    }

    void foo3() { foo4(); }

    void foo4() {
        if(i==0){
            i++;
            foo4();
        }
        System.out.println(i + " value");
    }

    int  foo5(String a, String  b) {
        Integer i = Integer.parseInt(a);
        Integer j = Integer.parseInt(b);
        return i/j;
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.foo5("1", "a"));
    }
}
