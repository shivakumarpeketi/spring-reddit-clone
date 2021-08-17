package com.programming.techie.springredditclone;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestMockAndSpy {
    @Spy
    A spyA = new A();

    @Mock
    B mockB = new B();

    @InjectMocks
    private A mockA;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockA() throws IOException {
        //given
//        A mockA = Mockito.mock(A.class);
//        Mockito.when(mockB.fooB()).thenReturn("Manually sending data through Mock");

        //when
        String result1 = mockA.foo1();
//        String result2 = mockA.foo2();

        //then
        assertEquals("RealString_1", result1);
//        assertEquals(null, result2);

        //Case 2
        //when
//        mockA.foo3();

        //then
//        verify(mockA).foo3();
//        verify(mockA, never()).foo4();
    }


    @Test
    public void testSpyA() {
        //given
//        A spyA = Mockito.spy(new A());



        //Mockito.when(spyA.foo1()).thenReturn("MockedString");

        //when
        String result1 = spyA.foo1();
        String result2 = spyA.foo2();

        //then
        assertNotEquals("MockedString", result1);
        assertEquals("RealString_2", result2);

        //Case 2
        //when
        spyA.foo3();

        //then
        verify(mockA).foo3();
//        verify(spyA).foo4();
    }

}