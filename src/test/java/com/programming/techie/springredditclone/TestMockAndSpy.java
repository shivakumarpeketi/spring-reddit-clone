package com.programming.techie.springredditclone;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestMockAndSpy {
    @Spy
    A spyA = new A();

//    @Mock
@Spy
    B mockB = new B();

    @InjectMocks
    private A injectedA;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockA() throws IOException {
        A mockA = Mockito.mock(A.class);
//        Mockito.when(mockB.fooB()).thenReturn("Manually sending data through Mock");
        Mockito.doReturn("Manually sending data through Mock").when(mockB);

        //when
        String result1 = injectedA.foo1();
        String result2 = mockB.fooB();

        //then
        assertEquals("RealString_1", result1);
        assertEquals("Manually sending data through Mock", result2);
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
        String result1 = injectedA.foo1();
        String result2 = spyA.foo2();

        //then
        assertNotEquals("Mock test", result1);
        @("RealString_2", result2);

        //Case 2
        //when
        spyA.foo3();

        //then
        verify(spyA, times(2)).foo4();
        assertThrows(ArithmeticException.class, () -> {
            spyA.foo5("1", "0");
        });
//        verify(spyA).foo4();
    }

}