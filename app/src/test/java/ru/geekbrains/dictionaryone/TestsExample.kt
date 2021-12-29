package ru.geekbrains.dictionaryone

import org.junit.Assert.*
import org.junit.Test
import ru.geekbrains.dictionaryone.utils.ClassForTests

class TestsExample {
    val classForTest = ClassForTests()

    @Test
    fun test1(){
        assertEquals(true,classForTest.method1(1))
    }

    @Test
    fun test2(){
        assertNotEquals(1,classForTest.method2(2))
    }

    @Test
    fun test3(){
        assertArrayEquals(arrayOf(1,2,3),classForTest.method3())
    }

    @Test
    fun test4(){
        assertNull(classForTest.method4())
    }

    @Test
    fun test5(){
        assertNotNull(classForTest.method5())
    }

    @Test
    fun test6(){
        assertSame(classForTest.method6(),classForTest.method5())
    }
}