package com.programming.techie.springredditclone;

import java.io.IOException;

class A {
    private B b;
    String foo1()  throws IOException  {
//        foo2();
        b.fooB();
        System.out.println("Class A with foo1");
        return "RealString_1";
    }

    String foo2() {
        return "RealString_2";
    }

    void foo3() { foo4(); }

    void foo4() { }
}
